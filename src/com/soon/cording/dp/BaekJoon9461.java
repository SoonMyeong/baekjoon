package com.soon.cording.dp;

import java.util.Scanner;

//파도반 수열
//값이 매우 커지므로 long 선언 필요
public class BaekJoon9461 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        long[] dp = new long[101];

        for(int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }

        for(int num : arr) {
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            for(int j=4; j<=num; j++) {
                dp[j] = dp[j-3]+dp[j-2];
            }
            System.out.println(dp[num]);
        }
    }
}
