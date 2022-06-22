package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	int num = 5;
    int[]arr = new int[num+1];
        for (int i = 2; i <=num; i++) {
            arr[i] = -1;
        }
        System.out.println(Arrays.toString(arr));
        fibonacciRecursion(num);
        fibonacciDpMemoization(num, arr);
        fibonacciDpTabulation(num);


    }

    private static void fibonacciDpTabulation(int num) {


    }

    private static void fibonacciDpMemoization(int num, int[] arr) {


    }

    private static int fibonacciRecursion(int num){
        if(num<2){
            return 1;
        }
        return fibonacciRecursion(num-1) + fibonacciRecursion(num-2);
 }
}
