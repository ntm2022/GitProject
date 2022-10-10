package com.codegym;
import java.util.Scanner;

public class UseQuadraticEquation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a:");
        double a = scanner.nextDouble();
        System.out.print("Enter b:");
        double b = scanner.nextDouble();
        System.out.print("Enter c:");
        double c = scanner.nextDouble();

        QuadraticEquation result = new QuadraticEquation(a, b, c);
        System.out.println(result.getA());
        System.out.println(result.getB());
        System.out.println(result.getC());
        if(result.getDiscriminant()>0){//delta>=0, pt co 02 nghiem
            System.out.print(result.getRoot1());
            System.out.print(result.getRoot2());
        }else if(result.getDiscriminant()==0){//delta==0, pt co 01 nghiem do 02 nghiem bang nhau. Vi du: x2 +2x + 1 =0
            System.out.print(result.getRoot1());
        }else{
            System.out.print("The equation has no roots");
        }

    }
}
