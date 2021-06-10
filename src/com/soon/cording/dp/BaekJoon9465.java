package com.soon.cording.dp;

import java.util.Scanner;

/**
 * 역시 DP 문제 이며, <br>
 * 대각선으로 최대 2칸까지 갈 수 있다. (이게 중요)<br>
 * 이를 기준으로 조건을 세워 보면 0번째 행과 , 1번째 행에 대한 점화식을 잡아 주면 된다. <br>
 *
 * dp[0][1] = arr[0][1];
 * dp[1][1] = arr[1][1];
 *
 * dp[0][i] = max(dp[1][i-2], dp[1][i-1]) + arr[0][i] ;
 * dp[1][i] = max(dp[0][i-2], dp[0][i-1]) + arr[1][i] ;
 */
public class BaekJoon9465 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        for(int i =0; i<cnt; i++) {
            int n = scanner.nextInt();
            int[][] arr = new int[2][n+1];
            int[][] dp = new int[2][n+1];

            for(int j=0; j<2; j++) {
                for(int k=1; k<=n; k++) {
                    arr[j][k]= scanner.nextInt();
                }
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];
            for(int l=2; l<=n; l++) {
                dp[0][l] = Math.max(dp[1][l-2], dp[1][l-1]) + arr[0][l];
                dp[1][l] = Math.max(dp[0][l-2], dp[0][l-1]) + arr[1][l];
            }
            System.out.println(Math.max(dp[0][n] , dp[1][n]));
        }

    }
}
