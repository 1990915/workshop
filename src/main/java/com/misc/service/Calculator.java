package com.misc.service;

public class Calculator implements ICalculator {
    private int a;
    private int b;

    @Override
    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public int divide(int a, int b) {
        return a / b;
    }
}