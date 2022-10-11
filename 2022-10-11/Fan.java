package com.codegym;

public class Fan {
    /*2 hằng được đặt tên là SLOW, MEDIUM, và FAST với giá trị 1, 2, và 3 để biểu thị tốc độ quạt.*/
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;

    /*Trường speed có kiểu số nguyên (private int) để xác định tốc độ quạt, mặc định là SLOW*/
    private int speed = SLOW;

    /*Trường on có kiểu private boolean để xác định quạt đang bật hay tắt, mặc định là false (tắt).*/
    private boolean on = false;

    /*Trường radius có kiểu private double để xác định bán kính quạt, giá trị mặc định là 5*/
    private double radius = 5;

    /*Trường color có kiểu dữ liệu private String để xác định màu quạt, mặc định là blue*/
    private String color = "blue";

    /*Các getter và setter cho các thuộc tính*/
    public int getSpeed(){return this.speed;}
    public void setSpeed(int speed){this.speed = speed;}
    public boolean isOn(){return this.on;}
    public void setOn(boolean on){this.on = on;}
    public double getRadius(){return this.radius;}
    public void setRadius(double radius){this.radius = radius;}
    public String getColor(){return this.color;}
    public void setColor(String color){this.color = color;}

    /*Phương thức khởi tạo không tham số tạo đối tượng fan mặc định*/
    public Fan(){}

    /*Phương thức toString() trả về chuỗi chứa thông tin của quạt.
    Nếu quạt đang ở trạng thái on, phương thức trả về speed, color, và radius với chuỗi “fan is on”.
    Nếu quạt không ở trạng thái on, phương thức trả về color, radius với chuỗi “fan is off”.*/
    public String toString(){
        if(this.isOn()){
            return "Speed: " + this.getSpeed() + " Color: " + this.color + " fan is On.";
        }else{
            return " Color: " + this.color + " Radius: " + this.radius + " fan is OFF.";
        }
    }

    /*Vẽ sơ đồ UML cho lớp và cài đặt lớp*/
}
