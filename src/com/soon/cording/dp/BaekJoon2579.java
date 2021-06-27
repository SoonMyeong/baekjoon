package com.soon.cording.dp;

import java.util.Scanner;


//계단 오르는 데는 다음과 같은 규칙이 있다.

//1. 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
//2. 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
//3. 마지막 도착 계단은 반드시 밟아야 한다.

/**
 * 마지막 계단은 밟아야 한다 (반드시) 를 기준으로 점화식을 세우면 쉽게 새울 수 있다.
 * 1. 마지막 전 계단 밟은 경우 (n-1을 밟았을 경우 n은 밟아야하니 n-2는 밟지 못한다.)
 * 2. 마지막 전 계단 밟지 않은 경우 (n-1을 안밟았으니  n-2는 밟은게 된다.)
 * dp[n] = dp[n-3] + arr[n-1] + arr[n];
 * dp[n] = dp[n-2]+ arr[n];
 */

public class BaekJoon2579 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n+1];
        int[] dp  = new int[n+1];

        for(int i=1; i<=n; i++) {
            arr[i] = scanner.nextInt();
        }
        dp[1] = arr[1];
        if(n>=2){
            dp[2] = arr[1]+arr[2];
        }
        for (int i = 3; i <=n; i++) {
            dp[i] = Math.max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i]);
        }

        System.out.println(dp[n]);
    }
}
