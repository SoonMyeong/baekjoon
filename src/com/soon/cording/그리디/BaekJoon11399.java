package com.soon.cording.그리디;

import java.util.Arrays;
import java.util.Scanner;

//ATM
public class BaekJoon11399 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);

        int count = 0;
        int result = 0;
        for(int i=0; i<n; i++){
            count = count + arr[i];
            result = result + count;
        }

        System.out.println(result);

    }
}
