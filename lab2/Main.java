package com.lab2;

public class Main {
    public static void main(String[] args) {
        Stack myStack = new Stack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pull());
        System.out.println(myStack.pull());
        System.out.println(myStack.pull());
        System.out.println(myStack.isEmpty());
    }
}
