package application.ui;

import application.MainWindow;
import application.ui.parts.AppControlArea;
import application.ui.parts.GameInfoArea;
import application.ui.parts.PlayerControlArea;
import application.ui.parts.PlayerInfoArea;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 18.02.2025
 */

public class GuiPanel extends JPanel {

    private MainWindow window;

    private AppControlArea appControlArea;
    private PlayerInfoArea playerInfoArea;
    private GameInfoArea gameInfoArea;
    private PlayerControlArea playerControlArea;
    private JTextArea gameLog;
    private JScrollPane scrollLogManager;

    public GuiPanel(MainWindow window) {
        this.window = window;
        setLayout(new GridLayout(5, 1));
        setBackground(Color.BLACK);

        this.appControlArea = new AppControlArea(this);
        this.playerInfoArea = new PlayerInfoArea(this);
        this.gameInfoArea = new GameInfoArea(this);
        this.playerControlArea = new PlayerControlArea(this);

        this.gameLog = new JTextArea();
        this.gameLog.setEditable(false);
        this.gameLog.setLineWrap(true);
        this.scrollLogManager = new JScrollPane(gameLog);

        add(appControlArea);
        add(playerInfoArea);
        add(gameInfoArea);
        add(playerControlArea);
        add(scrollLogManager);
    }

    public void recordLog(String message) {
        gameLog.append(message + "\n");
    }

    public void startGame() {
        window.startGame();
        window.showMap();
    }

    public void directionPlayer(int keyButton){
        window.directionPlayer(keyButton);
        window.showMap();
    }

    public void updatePlayerInfo(int hp, int str, int x, int y){
        playerInfoArea.updatePlayerInfo(hp, str, x, y);
    }

    public void updateGameInfo(int enemies, int medPacks, int mapHeight, int mapWidth) {
        gameInfoArea.updateGameInfo(enemies, medPacks, mapHeight, mapWidth);
    }


}
