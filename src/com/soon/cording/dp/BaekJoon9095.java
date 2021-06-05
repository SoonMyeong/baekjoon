package com.soon.cording.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 1,2,3 더하기
// dp[n] 의 경우 dp[n-1] ,dp[n-2], dp[n-3] 의 합을 추가 해 주면 된다.
// dp[4] = dp[1]+dp[2]+dp[3] 의 합과 같게 된다. (이전 값에서 +1, +2, +3 을 더했을 때 현재 값이 나옴)
// 1,2,3 에 4까지 추가하게 될 경우 dp[n] = dp[n-1]+dp[n-2]+dp[n-3]+dp[n-4] 의 합이 된다. 또한 조건문은 5부터시작, dp[4]=7 선언 후 시작
public class BaekJoon9095 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] dp = new int[11];
        List<Integer> list = new ArrayList<>();

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=0; i<num; i++) {
            int n = scanner.nextInt();
            for(int j=4; j<=n; j++) {
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }
            list.add(dp[n]);
        }

        for(int s : list) {
            System.out.println(s);
        }

    }
}
