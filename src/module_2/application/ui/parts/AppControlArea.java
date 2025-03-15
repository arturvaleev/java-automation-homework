package application.ui.parts;

import application.ui.GuiPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 18.02.2025
 */

public class AppControlArea extends JPanel {

    private GuiPanel panel;

    private JButton startGame;
    private JButton exitGame;
    private JLabel areaTitle;

    public AppControlArea(GuiPanel panel) {
        this.panel = panel;
        setLayout(new GridLayout(3, 1));
        areaTitle = new JLabel("= Game Control =", SwingConstants.CENTER);
        startGame = new JButton("START");
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.startGame();

            }
        });
        exitGame = new JButton("EXIT");
        exitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(areaTitle);
        add(startGame);
        add(exitGame);
    }

}
