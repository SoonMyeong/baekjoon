package com.soon.cording.dp;

import java.util.Scanner;

/**
 * 가장 큰 증가 부분 수열
 *  11053 과 비슷한 유형 이지만 합을 구해야 하는 다른 문제
 */
public class BaekJoon11055 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] arr = new int[n];
        int [] dp = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }

        for(int i=0; i<n; i++) {
            dp[i] = arr[i];
            for(int j=0; j<i; j++) {
                if(arr[i]>arr[j] && dp[i]<dp[j]+arr[i]) {
                    dp[i] = dp[j] + arr[i]; // 하나 씩 쓰면서 쫓아가보면 이해 하기 쉬움
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
