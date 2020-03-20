package com.company;

// an algorithm for searching if a given 3 vertices are representing a right angled triangle

public class rightAngeledTriangle {
    public static void main(String[] args) {
        boolean x = isRightTriangle(3,4,5);
        if (x == true) {
            System.out.println("It is a Right angled triangle");
        }
        else {
            System.out.println("It isn't a Right angled triangle");
        }
    }
    public  static  boolean isRightTriangle(float x, float y, float z){
        if(((Math.pow(x,2)+Math.pow(y,2)) == Math.pow(z,2)) || ((Math.pow(y,2)+Math.pow(z,2)) == Math.pow(x,2)) || ((Math.pow(x,2)+Math.pow(z,2)) == Math.pow(y,2))){
            return true;
        }
        return false;
        }
    }

