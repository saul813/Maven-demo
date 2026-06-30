package com.example;

public class Calculator {

    // A simple method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int result = calc.add(10, 5);
        System.out.println("====================================");
        System.out.println("Hello World! Maven Daemon is working!");
        System.out.println("Execution Result (10 + 5): " + result);
        System.out.println("====================================");
    }
}
