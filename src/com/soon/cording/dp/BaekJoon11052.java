package com.soon.cording.dp;

import java.util.Scanner;

//카드 구매하기
//이 문제의 경우 1자리에서 구할 수 있는 수를 측정 한 뒤 (ex 4)
//예를 들어 dp[2] (2개로 가질수 있는 최대값) 에 p[2] 를 더하면 4장을 뽑는 경우 중 하나가 된다.
// 마찬가지로 dp[3] 일 경우엔 p[1] 을 더해 4장을 뽑는 케이스
// dp[1]일땐 p[3] , dp[0] 일땐 p[4] .. 이러한 케이스들 중 최대 값이 dp[4]의 값이 된다.
//D[4] = max {
//    D[4-1] +P[1],
//    D[4-2] + P[2],
//    D[4-3] + P[3],
//    D[4-4] + P[4]
//}
// dp[n] = max(dp[i-j]+p[j] , dp[i]);

public class BaekJoon11052 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] p = new int[n+1];
        int [] dp = new int[n+1];

        for(int i=1; i<=n; i++) {
            p[i] = scanner.nextInt();
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                dp[i] = Math.max(dp[i],dp[i-j]+p[j]);
            }
        }

        System.out.println(dp[n]);

    }
}
