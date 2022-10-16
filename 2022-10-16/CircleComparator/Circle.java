package com.codegym;

public class Circle {
    private double radius = 1.0;

    private String color = "red";//cai nay khai bao la public static se chay nhanh hon vi no khong thay doi???

    private boolean filled = false;
    public Circle(){};

    public Circle(double r){this.radius = r;};

    public Circle(double r, String color, boolean filled){
        this.radius = radius;
        this.color = color;
        this.filled = filled;
    }

    public double getRadius(){return this.radius;}

    public double getArea(){return Math.PI * Math.pow(this.radius, 2);}

    public String getColor(){return this.color;}

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
