package com.soon.cording.dp;

import java.util.*;

//이친수
// 노가다로 풀 수있으나, 원리 파악을 위해 자료수집 함
/**
 * 1 --> 1개
 * [10] --> 1개
 * 1 [00] , 1 [01], --> 2개
 * 10 [00], 10 [01], 10 [10] -> 3개
 * 10000, 10100, 10010, 10001, 10101 -> 5개
 *
 * 이친수를 만족하려면, 앞에 10은 고정이어야 한다.
 *  n이 4일 경우
 * 그 다음 [] 수를 보면 n-2 번째 값과, n-1번째의 값들을 동일하게 사용 한다.
 * 즉, dp[n] = dp[n-2] + dp[n-1] 이 된다.
 */
public class BaekJoon2193 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] dp = new long[91];

        dp[1] = 1;
        dp[2] = 1;

        for(int i=3; i<=n; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        System.out.println(dp[n]);
    }
}
