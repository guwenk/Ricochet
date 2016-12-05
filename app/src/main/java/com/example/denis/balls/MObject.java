package com.example.denis.balls;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;

/**
 * Created by denis on 05.12.2016.
 */

public class MObject {
    Vector2D pos;
    Vector2D velocity;
    Paint paint;
    Bitmap pic;
    float sizeS = 50f; //длина стороны квадрата
    float sizeC = 30f; //радиус круга
    private boolean velocityInMem = false;
    Vector2D velocityMem; //сохранение скорости в класс
    int resolutionX = 720;
    int resolutionY = 1280;




    MObject(float posX, float posY){
        pos = new Vector2D(posX, posY);
        paint = new Paint();
    }
    MObject(float posX, float posY, int color){
        pos = new Vector2D(posX, posY);
        paint = new Paint();
        paint.setColor(color);
    }
    MObject(Bitmap pic){
        this.pic = pic;
    }
    MObject(float posX, float posY, float size, int color){
        pos = new Vector2D(posX, posY);
        paint = new Paint();
        paint.setColor(color);
        this.sizeC = size;
        this.sizeS = size;
    }




    void drawCircle(Canvas canvas){ //Создание круга
        canvas.drawCircle(pos.x, pos.y, this.sizeC, paint);
    }
    void drawSquare(Canvas canvas){ //Создание квадрата
        canvas.drawRect(pos.x, pos.y, pos.x+this.sizeS, pos.y+sizeS, paint);
    }




    void moveC(float x, float y, int resolutionX, int resolutionY){ //Движение круга
        this.resolutionX = resolutionX;
        this.resolutionY = resolutionY;
        velocity = new Vector2D(x, y);
        if (!velocityInMem) {
            velocityMem = velocity;
            velocityInMem = !velocityInMem;
        }
        if ((pos.x >= resolutionX - sizeC && velocityMem.x > 0) || (pos.x <= sizeC && velocityMem.x < 0)) {
            velocityMem.changeX(velocityMem);
        }
        if ((pos.y >= resolutionY - 250 - sizeC && velocityMem.y > 0) || (pos.y <= 0 + sizeC && velocityMem.y < 0)) {
            velocityMem.changeY(velocityMem);
        }
        pos.add(velocityMem);
    }
    void moveS(float x, float y, int resolutionX, int resolutionY){ //Движение квадрата
        this.resolutionX = resolutionX;
        this.resolutionY = resolutionY;
        velocity = new Vector2D(x, y);
        if (!velocityInMem) {
            velocityMem = velocity;
            velocityInMem = !velocityInMem;
        }
        if (pos.x <= 1280-sizeS || pos.x <= 0){
            velocityMem.changeX(velocityMem);
        }
        if (pos.y >= 800-185 || pos.y <= 0){
            velocityMem.changeY(velocityMem);
        }
        pos.add(velocityMem);
    }




    boolean isTouchedS(MotionEvent event){
        return (event.getX() > pos.x && event.getX() < pos.x+sizeS &&
                event.getY() > pos.y && event.getY() < pos.y+sizeS);
    }
    boolean isTouchedC(MotionEvent event){
        return (event.getX() > pos.x-sizeC && event.getX() < pos.x+sizeC && event.getY() > pos.y-sizeC && event.getX() < pos.y+sizeC);
    }
}
