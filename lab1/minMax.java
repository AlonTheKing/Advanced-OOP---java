package com.company;

// am algorithm to search the max - min numbers of a certain number

public class minMax {
    public static void main(String[] args) {
        minMaxFind(1234422147);
    }
    public static void minMaxFind(int number){
        int min = 10000;
        int max = -10000;
        int num = number;
        while (number != 0){
            if (min>number%10){
                min = number%10;
            }
                number /= 10;
        }
        while (num != 0){
            if (max<num%10){
                max = num%10;
            }
                num /= 10;
        }
        System.out.println("max: " + max + "\n" + "min: " + min);
    }
}


