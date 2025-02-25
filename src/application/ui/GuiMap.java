package application.ui;

import application.MainWindow;
import application.actors.Enemy;
import application.actors.MedPack;
import application.actors.Player;
import application.tools.Tools;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 18.02.2025
 */

public class GuiMap extends JPanel {

    private MainWindow window;

    public static final int MOVE_UP = 8;
    public static final int MOVE_LEFT = 4;
    public static final int MOVE_RIGHT = 6;
    public static final int MOVE_DOWN = 2;

    private static final int CELL_PLAYER = 0;
    private static final int CELL_ENEMY = 1;
    private static final int CELL_EMPTY = 2;
    private static final int CELL_MED_PACK = 3;
    private static final int CELL_EXIT = 4;
    private static final int CELL_READY = 5;

    public int[][] map;
    public int[][] invisibleMap;
    public int mapWidth;
    public int mapHeight;
    public int minSizeMap = 3;
    public int maxSizeMap = 6;

    public boolean isFoundExit = false;

    private Player player;
    private Enemy enemy;
    private MedPack medPack;

    public GuiMap(MainWindow window) {
        this.window = window;
        setBackground(Color.ORANGE);
    }

    public void showMap(JButton[][] buttons){

        removeAll();

        setLayout(new GridLayout(mapHeight, mapWidth));


        for (int i = 0; i < mapHeight; i++) {
            for (int j = 0; j < mapWidth; j++) {
                buttons[i][j] = new JButton();
                if (i == player.getY() && j == player.getX()) {
                    buttons[i][j].setText("Player");
                }
                add(buttons[i][j]);
            }

        }

        revalidate();
        repaint();

        window.updatePlayerInfo(player.getHealth(), player.getPower(), player.getY(), player.getX());

        isPlayerLose();

    }

    /**
     * При нажатии кнопки START на UI
     */
    public void startNewGame() {
        player = new Player();
        createMap();
        createMapButtons();
        createPlayer();
        createHealthPack();
        createEnemies();
        createExit();
        window.updateGameInfo(enemy.getCount(), medPack.getCount(), mapHeight, mapWidth);
    }

    public void directionPlayer(int keyButton) {
        int currentX = player.getX();
        int currentY = player.getY();

        do {
            switch (keyButton) {
                case MOVE_UP: {
                    player.moveUp();
                    break;
                }
                case MOVE_LEFT: {
                    player.moveLeft();
                    break;
                }
                case MOVE_RIGHT: {
                    player.moveRight();
                    break;
                }
                case MOVE_DOWN: {
                    player.moveDown();
                    break;
                }
                default: {
                    System.out.println("Wrong direction!");
                }
            }
        } while (!isValidMove(currentX, currentY, player.getX(), player.getY()));

        playerNextMoveAction(currentX, currentY, player.getX(), player.getY());
    }

    private void playerNextMoveAction(int currentX, int currentY, int nextX, int nextY) {
        if (invisibleMap[nextY][nextX] == CELL_MED_PACK) {
            player.health(medPack.getValue());
            window.recordLog(String.format("Player HP +%s. Now hp is %s", medPack.getValue(), player.getHealth()));
        }
        if (invisibleMap[nextY][nextX] == CELL_ENEMY) {
            player.getDamage(enemy.getPower());
            window.recordLog(String.format("Warning! Player HP -%s. Now hp is %s", enemy.getPower(), player.getHealth()));
        }
        if (invisibleMap[nextY][nextX] == CELL_EXIT) {
            isFoundExit = true;
            window.recordLog("Player found exit!");
            window.playerWin();
        }

        invisibleMap[currentY][currentX] = CELL_EMPTY;
        map[currentY][currentX] = CELL_READY;
        map[player.getY()][player.getX()] = CELL_PLAYER;
    }

    private boolean isValidMove(int currentX, int currentY, int nextX, int nextY) {
        if (nextY >= 0 && nextY < mapHeight && nextX >= 0 && nextX < mapWidth) {
            return true;
        }
        window.recordLog("Sorry, your move is incorrect");
        player.setPosition(currentX, currentY);
        return true;
    }

    private void createMap() {
        mapWidth = Tools.getRandomValue(minSizeMap, maxSizeMap);
        mapHeight = Tools.getRandomValue(minSizeMap, maxSizeMap);
        map = new int[mapHeight][mapWidth];
        invisibleMap = new int[mapHeight][mapWidth];

        for (int i = 0; i < mapHeight; i++) {
            for (int j = 0; j < mapWidth; j++) {
                map[i][j] = CELL_EMPTY;
                invisibleMap[i][j] = CELL_EMPTY;
            }
        }
        window.recordLog(String.format("Map created. Size %sx%s", mapHeight, mapWidth));
    }

    private void createPlayer() {
        player.setPosition(Tools.getRandomValue(0, mapWidth - 1), Tools.getRandomValue(0, mapHeight - 1));
        map[player.getY()][player.getX()] = CELL_PLAYER;
        window.recordLog(String.format("Player spawn in [%s;%s]", player.getY(), player.getX()));
    }

    public void createHealthPack() {
        medPack = new MedPack();
        MedPack.COUNT = Tools.getRandomValue(1, (maxSizeMap + minSizeMap) / 4);

        for (int i = 0; i < MedPack.COUNT; i++) {
            do {
                medPack.setPosition(Tools.random.nextInt(mapWidth), Tools.random.nextInt(mapHeight));
            } while (!isEmptyCell(medPack.getY(), medPack.getX()));
            invisibleMap[medPack.getY()][medPack.getX()] = CELL_MED_PACK;
        }
        window.recordLog(String.format("HealthPacks spawn. Count: %s", MedPack.COUNT));
    }

    private void createEnemies() {
        Enemy.COUNT = Tools.getRandomValue(1, (maxSizeMap + minSizeMap) / 4);
        enemy = new Enemy();

        for (int i = 0; i < Enemy.COUNT; i++) {
            do {
                enemy.setPosition(Tools.random.nextInt(mapWidth),
                        Tools.random.nextInt(mapHeight));
            } while (!isEmptyCell(enemy.getY(), enemy.getX()));
            invisibleMap[enemy.getY()][enemy.getX()] = CELL_ENEMY;
        }
        window.recordLog(String.format("Enemies spawn. Count: %s. Health: %s. Power: %s",
                Enemy.COUNT , enemy.getHealth(), enemy.getPower()));
    }

    private void createExit() {
        isFoundExit = false;
        int x;
        int y;
        do {
            x = Tools.random.nextInt(mapWidth);
            y = Tools.random.nextInt(mapHeight);
        } while (!isEmptyCell(y, x));
        invisibleMap[y][x] = CELL_EXIT;
        window.recordLog("Exit spawn");
    }

    private boolean isEmptyCell(int y, int x) {
        return map[y][x] == CELL_EMPTY && invisibleMap[y][x] == CELL_EMPTY;
    }

    private void isPlayerLose(){
        if (player.getHealth() < 0){
            window.playerLose();
        }
    }

    public JButton [][] createMapButtons(){
        JButton[][] buttons = new JButton[mapHeight][mapWidth];
        return buttons;
    }
}
