package com.example.denis.balls;

import android.graphics.Canvas;

interface Drawable {
    void drawObject(Canvas canvas, byte figure);
    void move (float x, float y, int resX, int resY);
}
