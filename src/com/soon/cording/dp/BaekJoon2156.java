package com.soon.cording.dp;

import java.util.Scanner;

/**
 * top-down
 * n번째 잔의 값을 구할 때 <br>
 * 1) n-1번째 잔을 마시지 않았을 경우 -> dp[n-2] + arr[i]
 * 2) n-1번째 잔을 마셨을 경우 -> dp[n-3] + arr[i-1] + arr[i] ;
 * 3) n-1 번째와 n-2번째를 건너 뛸 경우 -> Math.max(dp[i],dp[i-1]);
 *  dp[i-1]은 포도주를 연속 0번 마실 수 있는 경우 dp[i]==dp[i-1] 이 된다.
 *  즉, 두번 건너뛸 경우 0번 연속 마신 경우와 비교해 max 값을 찾아 낸다.
 */
public class BaekJoon2156 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] arr = new int[count+1];
        int[] dp = new int[count+1];
        for(int i=1; i<=count; i++) {
            arr[i] = scanner.nextInt();
        }
        dp[1] = arr[1];
        dp[2] = arr[1]+arr[2];
        for(int i=3; i<=count; i++) {
            dp[i] = Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i-1]+arr[i]);
            dp[i] = Math.max(dp[i-1],dp[i]);
        }
        System.out.println(dp[count]);
    }
}
