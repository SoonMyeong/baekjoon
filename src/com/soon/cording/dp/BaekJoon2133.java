package com.soon.cording.dp;

import java.util.Scanner;

//타일 채우기 (hard..)

/**
 * dp [2] = 3
 * dp [4] = dp[2]*3 + 2
 * -> dp[2]가 3가지인데 거기에 블럭 3x2 붙인 거니까 *3 마지막 새로운케이스 +2
 * dp [6] = dp[4]*3 + dp[2]*2 + 2
 * -> dp[4]에 블럭3x2 붙인거니까 dp[4]*3  에다가
 *  dp[4]일 때 나온 새로운 케이스에도 3x2가 붙으니까 dp[2]*2 , 마지막 새로운케이스 +2
 * dp [8] = dp[6]*3 + dp[4]*2 + dp[2]*2 + 2
 * -> dp[6]에 블럭 3x2 붙인거니까 dp[6]*3 에다가
 *  dp[6]일 때 나온 새로운 케이스(dp[4]) 에도 3x2가 붙으니까 dp[4]*2 + dp[2]*2 , 마지막 새로운케이스 +2
 *
 * 하...
 *
 */
public class BaekJoon2133 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] dp = new int[n+1];
        dp[0] = 1; //아무것도 안채운 경우..일 때 1가지...ㅋㅋㅋ 와...
        dp[2] = 3;

        for(int i=4; i<=n; i++) {
            dp[i] = dp[i-2]*3; // 3x2 도형 case

            // 3x4 , 3x6 , 3x8 ... 3x2n , 계속 새로운 타일이 추가 되어 만들어 진다.
            for(int j=4; j<=i; j+=2) {
                dp[i] += dp[i-j] *2;
            }
        }
        System.out.println(dp[n]);
    }
}
