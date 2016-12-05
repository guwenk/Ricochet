package com.example.denis.balls;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import java.util.Random;

/**
 * Created by denis on 05.12.2016.
 */

public class MyDraw extends View implements Button.OnClickListener{
    Vector2D v;
    MObject[] arrMO;
    private Random rand;
    int resX = 300;
    int resY = 300;
    int borderY;

    public MyDraw(Context context, AttributeSet attrs, Vector2D v) {
        super(context, attrs);
        this.v = v;
    }

    public MyDraw(Context context, AttributeSet attrs) {
        super(context, attrs);
        rand = new Random();
        v = new Vector2D(100,150);
        arrMO = new MObject[50];
        for (int i = 0; i < arrMO.length; ++i)
            arrMO[i] = new MObject((float)(Math.random() * 100+50), (float)(Math.random() * 100+50), (float)(Math.random()*25+10), Color.rgb(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));

    }
    Paint paint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        borderY = resY-250;
        canvas.drawLine(0, borderY, resX, borderY, paint);
        for(int i = 0; i < arrMO.length; i++)
        {
            arrMO[i].drawCircle(canvas);
            arrMO[i].moveC((float)((Math.random() * 500-250)*0.01),(float)((Math.random() * 500-250)*0.01), resX, resY);
        }

        invalidate();
    }




    @Override
    public void onClick(View view) {
        for (int i = 0; i < arrMO.length; ++i){
            arrMO[i].velocityMem.mul(-1);
        }
    }
}
