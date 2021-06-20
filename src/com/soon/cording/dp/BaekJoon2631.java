package com.soon.cording.dp;

import java.util.Scanner;

/**
 * 11055 번 문제를 풀다 추천된 문제여서 풀어 봄
 * LIS 알고리즘 (최장 증가 부분 수열) , 최소한의 이동으로 정렬 할 때 사용
 * 전체길이 - 증가된 부분수열의 크기 을 구해야 한다.
 * ex) {5,4,3,2,1} 의 경우 LIS 는 1이 되고,
 * 전체 길이 5-1 = 4 즉 4번의 이동을 하게 되는것이 번호 순서대로 정렬하는 최소한의 횟수가 된다.
 */
public class BaekJoon2631 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] arr = new int[n];
        int [] dp = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }
        dp[0] = 1;
        for(int i=0; i<n; i++) {
            dp[i] = 1; //길이니까 최소 1
            for(int j=0; j<i; j++) {
                if(arr[i]>arr[j] && dp[i] < dp[j] +1 ) {
                    dp[i] = dp[j] +1;
                }
            }
        }
        int max = 0;
        for(int i: dp) {
            max = Math.max(i,max);
        }
        System.out.println(n-max);
    }
}
