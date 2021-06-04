package com.soon.cording.dp;

import java.util.Scanner;

// 점화식 뽑아내는게 쉽지않네..?!
// 1) dp[n] = dp[n-1]+1  -- 1을 뺐을 때 1이 되는 경우
// 2) dp[n] = dp[n/3] +1 -- 3으로 나눴을 때 1이 되는 경우
// 3) dp[n] = dp[n/2] +1 -- 2로 나눴을 때 1이 되는 경우
public class BaekJoon1463 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int count = 0;
        int[] dp = new int[1000001];
        dp[1] = 0;
        for(int i=2; i<=num; i++) {
            dp[i] = dp[i-1] +1;
            if(i%3==0) {
                dp[i] = Math.min(dp[i],dp[i/3]+1);
            }
            if(i%2==0) {
                dp[i] = Math.min(dp[i],dp[i/2]+1);
            }
        }
        System.out.println(dp[num]);
    }
}
