package com.soon.cording.dp;

import java.util.Scanner;

//가장 긴 감소하는 부분 수열
// 11053 과 거의 흡사한 문제. 근데 풀 때마다 헤깔림 외워도 잘 모르겠네
public class BaekJoon11722 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] arr = new int[n];
        int [] dp = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }

        for(int i=0; i<n; i++) {
            dp[i] = 1;
            for(int j=0; j<i; j++) {
                if(arr[i]<arr[j] && dp[i]<dp[j]+1) {
                    dp[i] = dp[j]+1;
                }
            }
        }
        int max = 0;
        for(int i : dp) {
            max = Math.max(i,max);
        }
        System.out.println(max);
    }
}
