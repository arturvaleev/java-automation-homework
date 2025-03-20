package module_3.lesson_1.homework.app;

import module_3.lesson_1.homework.app.objects.Circle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 11.03.2025
 */

public class Circles extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int POS_X = 500;
    private static final int POS_Y = 260;

    //Считаю количество текущих шаров
    private int countCircles = 5;
    private int maxCircles = 15;
    //Установил изначально 15 ячеек для объектов, так как динамически массив расширить не получится
    Circle[] sprites = new Circle[maxCircles];

    public Circles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setTitle("Circles");
        setLocation(POS_X, POS_Y);

        Canvas canvas = new Canvas(this);
        add(canvas, BorderLayout.CENTER);

        //Добавил слушателя
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Вызываю метод провеки на достижение лимита добавления шаров, до вызова метода добавления
                if (!isMaxCircles(countCircles, maxCircles)){
                    addSpritesClick();
                }
            }
        });

        addSprites();

        setVisible(true);
    }

    private void addSprites() {
        for (int i = 0; i < countCircles; i++) {
            sprites[i] = new Circle();
        }
    }

    public void onRenderFrame(Canvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(Canvas canvas, float deltaTime) {
        for (int i = 0; i < countCircles; i++) {
            sprites[i].update(canvas, deltaTime, sprites);
        }
    }

    private void render(Canvas canvas, Graphics g) {
        for (int i = 0; i < countCircles; i++) {
            sprites[i].render(canvas, g);
        }
    }

    //Метод для добавления шаров по клику (добавляю объект Circle в свободную ячейку массива)
    private void addSpritesClick () {
        sprites[countCircles] = new Circle();
        countCircles++;
    }

    //Добавил отдельный метод для проверки на превышение лимита добавления шаров
    private boolean isMaxCircles(int countCircles, int maxCircles){
        if (countCircles >= maxCircles){
            Canvas.maxCountSprites();
            return true;
        }
        else {
            return false;
        }
    }

}
