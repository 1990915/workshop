package com.misc.effective_java;

public class IntegerCache {
    public static void main(String[] args) throws Exception {


        Integer a = 200;
        Integer b = 200;
        System.out.println("1:" + (a == b)); // true, comes from cache

        /*Integer x = -200;
        Integer y = -200;
        System.out.println("2:" + (x == y));*/
        int twoNoSum = sum(null, 50);
        System.out.println(twoNoSum);
    }

    private static int sum(Integer a, Integer b) {
        return a + b;
    }


}
