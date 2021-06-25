package com.soon.cording.dp;

import java.util.Scanner;

// 연속 합
// 이번 문제는 기존 부분수열 구하는 문제는 아니고, 메모이제이션만 잘 찾아 내면 쉬운 문제였다고 한다..
public class BaekJoon1912 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] arr  = new int[n];
        int [] dp = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }

        int max = arr[0];
        dp[0] = arr[0];
        for(int i=1; i<n; i++) {
            dp[i] = Math.max(dp[i-1]+arr[i],arr[i]);
        }

        for(int i : dp) {
            max = Math.max(i,max);
        }
        System.out.println(max);
    }
}
