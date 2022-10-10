package com.codegym;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a,double b,double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /*Phương thức gettter cho a, b và c.*/
    public  double getA (){return this.a;   }
    public  double getB (){return this.b;   }
    public  double getC (){return this.c;   }

    /*Phương thức getDiscriminant() trả về delta theo công thức delta = b2 - 4ac.*/
    public double getDiscriminant(){
        return Math.pow(this.b,2) - 4 * this.a * this.c;
    }

    /*Phương thức getRoot1() và getRoot2() trả về 02 nghiệm của phương trình là:*/
    public double getRoot1(){
        return (-this.b + Math.pow(Math.pow(this.b,2) - 4 * this.a * this.c, 0.5))/2 * this.a;
    }

    public double getRoot2(){
        return (-this.b - Math.pow(Math.pow(this.b,2) - 4 * this.a * this.c, 0.5))/2 * this.a;

    }
    /*Vẽ sơ đồ UML cho lớp QuadraticEquation và cài đặt lớp.*/
}
