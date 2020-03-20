package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// an algorithm to search the fibonacci's numbers up to a certain number

public class fibNum {
    private static List<Integer> cache = new ArrayList<Integer>();
    public static void main(String[] args) {
        fibNumbers(10);
        Collections.sort(cache);
        System.out.println("my numbers are: " + duplicate(cache ,cache.size()));

    }
    public static int fibNumbers(int n){
        if (n==1 || n==0){
            cache.add(n);
            return 1;
        }
        cache.add(n);
        return fibNumbers(n-2) + fibNumbers(n-1);
    }
    public static String  duplicate(List<Integer> myList, int size){
        if (size ==0 || size ==1){
            Object[] arr = myList.toArray();
            return Arrays.toString(arr);

        }

        List<Integer> temp = new ArrayList<Integer>();
        int j = 0;
        for (int i=1;i<size;++i){
            if(myList.get(i) != myList.get(i-1)){
                temp.add(j++, myList.get(i));
            }
        }
        Object[] arr = temp.toArray();
        return Arrays.toString(arr);

    }
}

