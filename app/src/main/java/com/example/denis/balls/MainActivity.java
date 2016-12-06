package com.example.denis.balls;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(new MyDraw(this));
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        final MyDraw mydraw = (MyDraw)findViewById(R.id.view);
        View rl = findViewById(R.id.rl);
        rl.setOnTouchListener(this);

        final Button buttonReverse = (Button)findViewById(R.id.button);
        buttonReverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < mydraw.arrMO.length; ++i){
                    mydraw.arrMO[i].velocityMem.mul(-1);
                }
            }
        });

        final Button btnSpeedUp = (Button)findViewById(R.id.buttonSpeedUp);
        btnSpeedUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < mydraw.arrMO.length;i++){
                    mydraw.arrMO[i].velocityMem.set(mydraw.arrMO[i].velocityMem.x * 1.1f,mydraw.arrMO[i].velocityMem.y * 1.1f);
                }
            }
        });
        final Button btnSlowDown = (Button)findViewById(R.id.buttonSlowDown);
        btnSlowDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < mydraw.arrMO.length;i++){
                    mydraw.arrMO[i].velocityMem.set(mydraw.arrMO[i].velocityMem.x / 1.1f,mydraw.arrMO[i].velocityMem.y / 1.1f);
                }
            }
        });

        final Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        Point p = new Point();
        display.getSize(p);
        mydraw.setResolution(p.x, p.y);
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        final MyDraw mydraw = (MyDraw)findViewById(R.id.view);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("Touch","ACTION_DOWN");
                for (int i = 0; i < mydraw.arrMO.length; i++) {
                    if (mydraw.arrMO[i].isTouched(event.getX(),event.getY())) {
                        mydraw.arrMO[i].velocityMem.mul(-1);
                    }
                    Log.d("FigureID["+mydraw.arrMO[i].figure+"]", mydraw.arrMO[i].pos.x+" ; "+mydraw.arrMO[i].pos.y);
                }
                Log.d("Coords",event.getX() + " ; " + event.getY());

                break;
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL: break;
        }
        return true;
    }
}
