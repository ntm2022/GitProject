package com.codegym;
/*Viết chương trình Hiển thị các đối tượng bằng cách gọi phương thức toString*/

public class UseFan {
    public static void main(String[] args) {
        /*Tạo 2 đối tượng Fan*/
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();

        /*Đối tượng Fan 1: Gán giá trị lớn nhất cho speed, radius là 10, color là yellow và quạt ở trạng thái bật.*/
        fan1.setSpeed(fan1.FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);

        /*Đối tượng Fan 2: Gán giá trị trung bình cho speed, radius là 5, color là blue và quạt ở trạng thái tắt*/
        fan2.setSpeed(fan2.MEDIUM);
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.setOn(false);

        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
