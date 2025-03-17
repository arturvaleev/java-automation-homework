package module_3.lesson_1.homework.app.objects;

import module_3.lesson_1.homework.app.Canvas;
import module_3.lesson_1.homework.app.Circles;
import module_3.lesson_1.homework.app.models.Sprite;

import java.awt.*;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 11.03.2025
 */

public class Circle extends Sprite {

    private float vectorX = (float) (100 + Math.random() * 250f);
    private float vectorY = (float) (100 + Math.random() * 250f);
    private final Color color = new Color(
            (int) (Math.random() * 255),
            (int) (Math.random() * 255),
            (int) (Math.random() * 255)
    );

    public Circle() {
        halfWidth = 10 + (float)(Math.random() * 50f);
        halfHeight = halfWidth;
    }

    @Override
    public void render(Canvas canvas, Graphics g) {
        g.setColor(color);
        g.fillOval((int) getLeft(),
                (int) getTop(),
                (int) getWidth(),
                (int) getHeight()
        );
    }

    @Override
    public void update(Canvas canvas, float deltaTime, Sprite[] sprites) {
        x += vectorX * deltaTime;
        y += vectorY * deltaTime;

        if (getLeft() < canvas.getLeft()) {
            setLeft(canvas.getLeft());
            vectorX = -vectorX;
        }
        if (getRight() > canvas.getRight()) {
            setRight(canvas.getRight());
            vectorX = -vectorX;
        }
        if (getTop() < canvas.getTop()) {
            setTop(canvas.getTop());
            vectorY = -vectorY;
        }
        if (getBottom() > canvas.getBottom()) {
            setBottom(canvas.getBottom());
            vectorY = -vectorY;
        }

        //Проверяю шары на столкновение и меняю их направление
        for (int i = 0; i < sprites.length; i++){

            //Выхожу из цикла, если в массиве больше нет объектов
            if (sprites[i] == null){
                break;
            }

            //Проверка для исключения проверки столкновения шара с собой
            if (this == sprites[i]){
                continue;
            }

            //Проверяю шары на столкновение ( Использую очень сомнительную логику =) )getHalfWidth()
            if (isChangeDirection(this, (Circle) sprites[i])){
                this.changeDirection();
                Circle otherCircle = (Circle) sprites[i];
                otherCircle.changeDirection();
            }
        }
    }

    //Добавил метод для изменения направления движения
    private void changeDirection() {
        vectorX = -vectorX;
        vectorY = -vectorY;
    }

    //Расчёт вычисления столкновений вынес в отдельный метод
    public boolean isChangeDirection(Circle circle, Circle otherCircle){
        //Разница по X и Y между центрами шаров
        float dx = circle.getX() - otherCircle.getX();
        float dy = circle.getY() - otherCircle.getY();

        //Квадрат расстояния между центрами
        float distanceSquared = dx * dx + dy * dy;

        //Сумма радиусов (в квадрате)
        float radiusSum = circle.getHalfWidth() + otherCircle.getHalfWidth();
        float radiusSumSquared = radiusSum * radiusSum;

        //Если квадрат расстояния меньше квадрата суммы радиусов, шары сталкиваются
        return distanceSquared < radiusSumSquared;
    }
}
