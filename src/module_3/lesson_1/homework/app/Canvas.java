package module_3.lesson_1.homework.app;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 11.03.2025
 */

public class Canvas extends JPanel {

    private final Circles window;
    private long lastUpdateTime;

    public Canvas(Circles window) {
        this.window = window;
        this.lastUpdateTime = System.nanoTime();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastUpdateTime) * 0.000000001f;
        lastUpdateTime = currentTime;
        window.onRenderFrame(this, g, deltaTime);

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        repaint();
    }

    public int getLeft() {
        return 0;
    }

    public int getRight() {
        return getWidth() - 2;
    }

    public int getBottom() {
        return getHeight() - 2;
    }

    public int getTop() {
        return 0;
    }

    //Метод для вывода сообщения о достижении лимита на добавление объектов.
    static public void maxCountSprites(){
        JOptionPane.showMessageDialog(null, "Вы добавили максимальное количество объектов!", "Больше добавить не получится!", JOptionPane.ERROR_MESSAGE);
    }
}
