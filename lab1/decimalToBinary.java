package com.company;

// an algorithm for converting a decimal number to a binary number

public class decimalToBinary {
    public static void main(String[] args) {
        System.out.println("Binary number is: " + decimalConv(10));
    }
    public static int decimalConv(int num){
        int res = 0;
        int res2 = 0;
        String a = "";
        String b = "";
        while(num != 0) {
            res = num % 2;
            a = a.concat(Integer.toString(res));
            num /= 2;
        }
        while(a.length() != 0){
            b = b + a.charAt(a.length()-1);
            a = a.substring(0, a.length()-1);
        }

        return Integer.parseInt(b);
    }
}
