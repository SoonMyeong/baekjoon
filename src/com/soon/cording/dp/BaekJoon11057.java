package com.soon.cording.dp;

import java.util.Scanner;

//오르막 수
//이 문제 역시 점화식만 잘 짜면 쉬워 보임

//_ _ 7 이면 두번쨰 자리는 0~7까지 숫자가 올 수있다. (참고)


public class BaekJoon11057 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] dp = new int[n+1][10];

        for(int i=0; i<=9; i++) {
            dp[1][i] = 1;
        }

        for(int i=2; i<=n; i++) {
            for(int j=0; j<=9; j++) {
              for(int k=0; k<=j; k++) { //_ _ 7 이면 두번쨰 자리는 0~7까지 숫자가 올 수있다. (참고)
                  dp[i][j] += dp[i-1][k] % 10007;
              }
            }
        }

        int sum = 0;
        for(int i=0; i<=9; i++) {
            sum+= dp[n][i];
        }
        System.out.println(sum % 10007);

    }
}
