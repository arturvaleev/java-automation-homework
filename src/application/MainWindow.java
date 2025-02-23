package application;

import application.ui.GuiMap;
import application.ui.GuiPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 18.02.2025
 */

public class MainWindow extends JFrame {

    private int windowWidth = 800;
    private int windowHeight = 600;

    private GuiMap guiMap;
    private GuiPanel guiPanel;

    public MainWindow() {
        setupWindow();
        this.guiMap = new GuiMap(this);
        this.guiPanel = new GuiPanel(this);

        add(guiMap);
        add(guiPanel, BorderLayout.EAST);

        setVisible(true);
    }

    private void setupWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(windowWidth, windowHeight);
        setTitle("My First UI App");
        setLocationRelativeTo(null);
        setResizable(true);
    }

    public void startGame() {
        guiMap.startNewGame();
    }

    public void showMap(){
        guiMap.showMap();
    }

    public void directionPlayer(int keyButton){
        guiMap.directionPlayer(keyButton);
    }

    public void recordLog(String message) {
        guiPanel.recordLog(message);
    }

    public void updatePlayerInfo(int hp, int str, int x, int y){
        guiPanel.updatePlayerInfo(hp, str, x, y);
    }

    public void updateGameInfo(int enemies, int medPacks, int mapHeight, int mapWidth) {
        guiPanel.updateGameInfo(enemies, medPacks, mapHeight, mapWidth);
    }

    public void playerWin(){
        JOptionPane.showMessageDialog(null, "Ура, вы нашли выход! Начните новую игру.", "Победа", JOptionPane.INFORMATION_MESSAGE);
    }

    public void playerLose(){
        JOptionPane.showMessageDialog(null, "Вы проиграли! Попробуйте снова.", "Поражение", JOptionPane.ERROR_MESSAGE);
    }
}
