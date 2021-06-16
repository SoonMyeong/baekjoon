package com.soon.cording.dp;

import java.util.*;

/**
 * 집중 하자...
 * bottom-up 방식의 2중포문으로 해결 가능
 */
public class BaekJoon11053 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }

        for(int i=0; i<n; i++) {
            dp[i] = 1;
            for(int j=0; j<i; j++) {
                if(arr[j]<arr[i] && dp[i] <=dp[j]) {
                    dp[i] = dp[j] +1;
                }
            }
        }
        int max = 0;
        for(int i : dp) {
            max = Math.max(max,i);
        }
        System.out.println(max);
    }
}
