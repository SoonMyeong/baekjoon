package com.soon.cording.dp;

import java.util.Scanner;

//제곱수의 합 -> 항의 최소 개수
//점화식 구하기가 어려운 문제..
//dp[i] = min(dp[i], dp[i-j*j]+1)
public class BaekJoon1699 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int [] dp = new int[num+1];

        for(int i=1; i<=num; i++) {
            dp[i] = i;
            for(int j=1; j*j<=i; j++) {
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        System.out.println(dp[num]);
    }
}
