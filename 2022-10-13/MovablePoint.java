package com.codegym;

public class MovablePoint extends Point{
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public MovablePoint() {}
    public MovablePoint(float x,float y, float xSpeed, float ySpeed) {
        super(x,y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }
    public void setSpeed(float xSpeed, float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public float[] getSpeed(){
        float[] arr = new float[2];
        arr[0] = this.xSpeed;
        arr[1] = this.ySpeed;
        return arr;
    }
    @Override
    public String toString(){
        //(x,y),speed=(xs,ys)
        return "(" + super.getX() + " , " + super.getY() + "),speed=(" + this.xSpeed + "," + this.ySpeed + ")";
    }
    public MovablePoint move(){
        float x = super.getX();
        float y = super.getY();
        x+= this.xSpeed;
        y+= this.ySpeed;
        super.setX(x);
        super.setY(y);
        return this;
    }
}
