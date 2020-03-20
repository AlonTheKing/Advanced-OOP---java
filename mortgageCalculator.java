package com.company;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
     int principal;
        float annualInterestRate;
        int period;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal: ");
        principal = scanner.nextInt();
        System.out.println("");
        System.out.print("Annual Interest Rate: ");
        annualInterestRate = scanner.nextFloat();
        float r = annualInterestRate/100/12;
        System.out.println("");
        System.out.print("Period: ");
        period = scanner.nextInt();
        period = period * 12;
        System.out.println("");
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        double result = Math.round(100*(float)principal*(r*Math.pow(1+r,period))/((Math.pow(1+r,period))-1))/100.0;
        String res = currency.format(result);
        System.out.println("Mortgage: " + res);



    }
}
