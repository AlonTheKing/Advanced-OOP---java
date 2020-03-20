package com.company;

import java.util.Scanner;

// algorithm for searching the area of a circle 

public class CircleArea {
    public static void main(String[] args) {
        double radius, area;
        Scanner scanner = new Scanner(System.in);
        // area of circle - pi*r^2
        System.out.print("Please enter radius: ");
        radius = scanner.nextDouble();
        area = Math.PI*Math.pow(radius,2);
        System.out.println("The area of the circle is: " + area);
    }
}

