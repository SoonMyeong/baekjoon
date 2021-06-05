package com.soon.cording.dp;

import java.util.Scanner;

// dp[N][L] = dp[N - 1][L - 1] + dp[N - 1][L + 1]
public class BaekJoon10844 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int modNum = 1000000000;
        int num = scanner.nextInt();
        long[][] dp = new long[num+1][10];

        //첫번째 자리 수일 경우 값은 모두 1개
        for(int i=1; i<=9; i++) {
            dp[1][i] = 1;
        }

        for(int i=2; i<=num; i++) {
            //끝자리가 0일 경우엔 1밖에 안됨
            dp[i][0] = dp[i-1][1] % modNum;

            for(int j=1; j<=9; j++) {
                if(j==9) { //끝자리가 9일경우엔 8밖에 안됨
                    dp[i][j] = dp[i-1][8] % modNum;
                }else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1] % modNum; // 마지막 자리수가 1~8 일 경우  -1이거나 +1 일 경우 의 합!
                }
            }
        }

        long sum = 0;
        for(int i=0; i<=9; i++) {
            sum+= dp[num][i];
        }

        System.out.println(sum % modNum);
    }
}
