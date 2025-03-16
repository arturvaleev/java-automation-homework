package module_3.lesson_1.homework.app.objects;

import module_3.lesson_1.homework.app.Canvas;
import module_3.lesson_1.homework.app.models.Sprite;

import java.awt.*;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 11.03.2025
 */

public class Circle extends Sprite {

    public float vectorX = (float) (100 + Math.random() * 250f);
    public float vectorY = (float) (100 + Math.random() * 250f);
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
    public void update(Canvas canvas, float deltaTime, Sprite[] sprites, int countCircles) {
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
        for (int i = 0; i < countCircles; i++){

            //Проверка для исключения проверки столкновения шара с собой
            if (this == sprites[i]){
                continue;
            }

            //Проверяю шары на столкновение ( Использую очень сомнительную логику =) )
            if ((Math.abs(this.x - sprites[i].getX()) < (this.halfWidth + sprites[i].getHalfWidth())) && (Math.abs(this.y - sprites[i].getY()) < (this.halfHeight + sprites[i].getHalfHeight()))){
                this.vectorX = -this.vectorX;

                Circle otherCircle = (Circle) sprites[i];
                otherCircle.vectorX = -otherCircle.vectorX;

                this.vectorY = -this.vectorY;

                otherCircle.vectorY = -otherCircle.vectorY;
            }
        }
    }
}
