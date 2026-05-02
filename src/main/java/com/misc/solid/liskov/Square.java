package com.misc.solid.liskov;

public class Square extends Rectangle {

    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width; // مربع => هر دو برابرند
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
        this.width = height; // مربع => هر دو برابرند
    }

}
