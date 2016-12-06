package com.example.denis.balls;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;


public class MyDraw extends View{
    MObject[] arrMO;
    private int resX = 300;
    private int resY = 300;

    public MyDraw(Context context, AttributeSet attrs) {
        super(context, attrs);
        Random rand = new Random();
        arrMO = new MObject[2];
        for (int i = 0; i < arrMO.length; i++)
            arrMO[i] = new MObject((float)(Math.random() * 100+50), (float)(Math.random() * 100+50), (float)(Math.random()*25+20), Color.rgb(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));

    }
    Paint paint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        int borderY;
        borderY = resY-250;
        canvas.drawLine(0, borderY, resX, borderY, paint);
        for(int i = 0; i < arrMO.length/2; i++) {
            arrMO[i].drawObject(canvas, arrMO[i].figureCircle());
            arrMO[i].move((float)((Math.random() * 500-250)*0.01),(float)((Math.random() * 500-250)*0.01),resX, resY);
        }
        for(int i = arrMO.length/2; i < arrMO.length; i++) {
            arrMO[i].drawObject(canvas, arrMO[i].figureSquare());
            arrMO[i].move((float)((Math.random() * 500-250)*0.01),(float)((Math.random() * 500-250)*0.01),resX, resY);
        }

        invalidate();
    }

    public void setResolution(int resX, int resY) {
        this.resX = resX;
        this.resY = resY;
    }

}
