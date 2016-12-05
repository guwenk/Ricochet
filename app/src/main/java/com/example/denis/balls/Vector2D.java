package com.example.denis.balls;

/**
 * Created by denis on 05.12.2016.
 */

public class Vector2D {
    float x, y;

    public String toString(){
        return "(" + x + "; " + y + ")";
    }
    public Vector2D(){
        this.x = 0;
        this.y = 0;
    }

    public void set(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void mul(float k){
        this.x *= k;
        this.y *= k;
    }

    public void add(Vector2D v){
        this.x += v.x;
        this.y += v.y;
    }
    public void deduct(Vector2D v){
        this.x -= v.x;
        this.y -= v.y;
    }
    public void reverseX(Vector2D v){
        this.x *=-1;
    }
    public void reverseY(Vector2D v){
        this.y *=-1;
    }

    public Vector2D(float x, float y){
        this.x = x;
        this.y = y;
    }

}
