package com.soon.cording.dp;

import java.util.Scanner;

//합분해
public class BaekJoon2225 {
    private static final long NUMBER = 1000000000;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long[][] dp = new long[201][201];

        for(int i=1; i<=k; i++) {
            dp[i][0] = 1;
        }

        /**
         * 합 N을 만들기 위해서는 정수 0~N 까지 다양하게 존재
         * 마지막값을 M 이라고 할 때
         * 마지막 값 M을 더하기 전까지의 합은 N-M 이 된다.
         * 또한 개수는 K에서 M을 제외하기 때문에 -1 을 뺀 값이 된다.
         * 즉, k개의 수로 합 N을 만들어 내기 위한 DP 점화식은
         *  dp[K][N] = = Σdp[K-1][N] 이 된다.
         */
        for(int i=1; i<=k; i++) {
            for(int j=1; j<=n; j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % NUMBER;
            }
        }
        System.out.println(dp[k][n]);
    }
}
