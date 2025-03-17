package module_3.lesson_1.homework.app.models;

import module_3.lesson_1.homework.app.Canvas;
import module_3.lesson_1.homework.app.objects.Circle;

import java.awt.*;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 11.03.2025
 */

public abstract class Sprite {


    protected float x;
    protected float y;
    protected float halfWidth;
    protected float halfHeight;

    public float getHalfHeight() {
        return halfHeight;
    }

    public float getHalfWidth() {
        return halfWidth;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setLeft(float left) {
        x = left + halfWidth;
    }

    public void setRight(float right) {
        x = right - halfWidth;
    }

    public void setTop(float top) {
        y = top + halfHeight;
    }

    public void setBottom(float bottom) {
        y = bottom - halfHeight;
    }

    public float getLeft() {
        return x - halfWidth;
    }

    public float getRight() {
        return x + halfWidth;
    }

    public float getTop() {
        return y - halfHeight;
    }

    public float getBottom() {
        return y + halfHeight;
    }

    public float getWidth() {
        return 2f * halfWidth;
    }

    public float getHeight() {
        return 2f * halfHeight;
    }

    protected abstract void render(Canvas canvas, Graphics g);

    //Добавил передачу массива Sprite и переменную количества шаров
    protected abstract void update(Canvas canvas, float deltaTime, Sprite[] sprites);

}
