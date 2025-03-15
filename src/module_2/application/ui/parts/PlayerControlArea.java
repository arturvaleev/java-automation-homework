package application.ui.parts;

import application.ui.GuiPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 18.02.2025
 */

public class PlayerControlArea extends JPanel {

    private GuiPanel guiPanel;

    private JButton btnMoveUp;
    private JButton btnMoveLeft;
    private JButton btnMoveRight;
    private JButton btnMoveDown;

    public PlayerControlArea(GuiPanel guiPanel) {
        this.guiPanel = guiPanel;

        setLayout(new GridLayout(2, 3));

        btnMoveUp = new JButton("↑");
        btnMoveUp.addActionListener(e -> guiPanel.directionPlayer(8));
        btnMoveLeft = new JButton("←");
        btnMoveLeft.addActionListener(e -> guiPanel.directionPlayer(4));
        btnMoveRight = new JButton("→");
        btnMoveRight.addActionListener(e -> guiPanel.directionPlayer(6));
        btnMoveDown = new JButton("↓");
        btnMoveDown.addActionListener(e -> guiPanel.directionPlayer(2));

        add(new JPanel());
        add(btnMoveUp);
        add(new JPanel());
        add(btnMoveLeft);
        add(btnMoveDown);
        add(btnMoveRight);
    }
}
