package com.example.denis.balls;

import android.graphics.Canvas;
import android.graphics.Paint;


class MObject {
    private Vector2D pos;
    Vector2D velocityMem; //сохранение скорости в класс
    private Paint paint;
    private float sizeS = 50f; //длина стороны квадрата
    private float sizeC = 30f; //радиус круга
    private boolean velocityMemCheck = false;
    private int resolutionX;
    private int resolutionY;




    MObject(float posX, float posY){
        pos = new Vector2D(posX, posY);
        paint = new Paint();
        resolutionX = 720;
        resolutionY = 1280;
    }
    MObject(float posX, float posY, int color){
        pos = new Vector2D(posX, posY);
        paint = new Paint();
        paint.setColor(color);
        resolutionX = 720;
        resolutionY = 1280;
    }
    MObject(float posX, float posY, float size, int color){
        pos = new Vector2D(posX, posY);
        paint = new Paint();
        paint.setColor(color);
        this.sizeC = size;
        this.sizeS = size;
        resolutionX = 720;
        resolutionY = 1280;
    }




    void drawCircle(Canvas canvas){ //Создание круга
        canvas.drawCircle(pos.x, pos.y, sizeC, paint);
    }
    void drawSquare(Canvas canvas){ //Создание квадрата
        canvas.drawRect(pos.x, pos.y, pos.x+sizeS, pos.y+sizeS, paint);
    }

    void move (float x, float y,byte figure ,int resX, int resY){
        Vector2D velocity;
        this.resolutionX = resX;
        this.resolutionY = resY;
        velocity = new Vector2D(x, y);
        if (!velocityMemCheck) {
            velocityMem = velocity;
            velocityMemCheck = true;
        }
        if (figure == figureCircle()){
            if ((pos.x >= resolutionX - sizeC && velocityMem.x > 0) || (pos.x <= sizeC && velocityMem.x < 0)) {
                velocityMem.reverseX();
            }
            if ((pos.y >= resolutionY - 250 - sizeC && velocityMem.y > 0) || (pos.y <= 0 + sizeC && velocityMem.y < 0)) {
                velocityMem.reverseY();
            }
        }else if (figure == figureSquare()){
            if ((pos.x >= resolutionX-sizeS && velocityMem.x > 0) || (pos.x <= 0 && velocityMem.x < 0)){
                velocityMem.reverseX();
            }
            if ((pos.y >= resolutionY - 250 - sizeS && velocityMem.y > 0) || (pos.y <= 0 && velocityMem.y < 0)){
                velocityMem.reverseY();
            }
        }
        pos.add(velocityMem);
    }


    byte figureCircle() {
        return 1;
    }
    byte figureSquare() {
        return 2;
    }
    /* Проверка косания
    boolean isTouchedS(MotionEvent event){
        return (event.getX() > pos.x && event.getX() < pos.x+sizeS &&
                event.getY() > pos.y && event.getY() < pos.y+sizeS);
    }
    boolean isTouchedC(MotionEvent event){
        return (event.getX() > pos.x-sizeC && event.getX() < pos.x+sizeC && event.getY() > pos.y-sizeC && event.getX() < pos.y+sizeC);
    }
    */
}
