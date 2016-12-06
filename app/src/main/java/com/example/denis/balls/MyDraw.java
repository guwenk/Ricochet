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

    public MyDraw(Context context, AttributeSet attrs) {
        super(context, attrs);
        Random rand = new Random();
        arrMO = new MObject[300];
        for (int i = 0; i < arrMO.length; i++)
            arrMO[i] = new MObject((float)(Math.random() * 100+50), (float)(Math.random() * 100+50), (float)(Math.random()*25+20), Color.rgb(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));

    }
    Paint paint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        int borderY = this.getHeight()-1;
        canvas.drawLine(0, borderY, this.getWidth(), borderY, paint);
        for(int i = 0; i < arrMO.length/2; i++) {
            arrMO[i].drawObject(canvas, arrMO[i].figureCircle());
            arrMO[i].move((float)((Math.random() * 500-250)*0.01),(float)((Math.random() * 500-250)*0.01),this.getWidth(), this.getHeight());
        }
        for(int i = arrMO.length/2; i < arrMO.length; i++) {
            arrMO[i].drawObject(canvas, arrMO[i].figureSquare());
            arrMO[i].move((float)((Math.random() * 500-250)*0.01),(float)((Math.random() * 500-250)*0.01),this.getWidth(), this.getHeight());
        }

        invalidate();
    }

}
