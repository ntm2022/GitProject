package com.codegym;

public class StudentWriteOnly {
    private String name = "John";
    private String classes = "C02";
    StudentWriteOnly(){}

    public void setName(String s){this.name = s; }

    public void setClasses(String s){this.classes = s;}

    /*public String toString(){
        return "Name: " + this.name + "Class: " + this.classes;
    }*/
}
