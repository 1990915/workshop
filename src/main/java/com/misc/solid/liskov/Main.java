package com.misc.solid.liskov;

public class Main {

    public static void calculateArea(Rectangle r) {
        r.setWidth(5);
        r.setHeight(10);
        System.out.println(r.getArea()); // انتظار 50
    }

    public static void main(String[] args) {
        calculateArea(new Rectangle()); // 50
        calculateArea(new Square()); // 100 ❌ رفتار اشتباه
    }
}
