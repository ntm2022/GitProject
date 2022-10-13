package com.codegym;

public class TestMovablePoint {
    public static void main(String[] args) {
        MovablePoint mPoint = new MovablePoint(20,30,100,200);
        System.out.println(mPoint);
        mPoint.move();
        System.out.println("After move..." + mPoint);
    }
}
