package com.example.denis.balls;


class Vector2D {
    float x, y;

    public String toString(){
        return "(" + x + "; " + y + ")";
    }
    public Vector2D(){
        this.x = 0;
        this.y = 0;
    }

    void set(float x, float y){
        this.x = x;
        this.y = y;
    }

    void mul(float k){
        this.x *= k;
        this.y *= k;
    }

    void add(Vector2D v){
        this.x += v.x;
        this.y += v.y;
    }
    void deduct(Vector2D v){
        this.x -= v.x;
        this.y -= v.y;
    }
    void reverseX(){
        this.x *=-1;
    }
    void reverseY(){
        this.y *=-1;
    }

    Vector2D(float x, float y){
        this.x = x;
        this.y = y;
    }

}
