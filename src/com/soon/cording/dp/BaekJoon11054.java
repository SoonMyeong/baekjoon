package com.soon.cording.dp;

import java.util.Scanner;

//가장 긴 바이토닉? 부분 수열
//이거야 말로 dp 점화식을 어떻게 짜야 되는걸까?
//올라갔다 내려가는 부분수열 << 이거
//왼쪽에서 시작하는 LIS 와 오른쪽에서 시작하는 LIS 의 합을 구한 뒤
// 중복되는 값 -1을 해 주면 바이토닉의 부분 수열의 길이를 구할 수 있다.
public class BaekJoon11054 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] arr = new int[n];
        int [] leftDp = new int[n];
        int [] rightDp = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }

        for(int i=0; i<n; i++) {
            leftDp[i] = 1;
            for(int j=0; j<i; j++) {
                if(arr[i]>arr[j] && leftDp[i] < leftDp[j]+1) {
                    leftDp[i] = leftDp[j] + 1;
                }
            }
        }

        for(int i=n-1; i>=0; i--) {
            rightDp[i] = 1;
            for(int j=n-1; j>i; j--) {
                if(arr[i] > arr[j] && rightDp[i] <rightDp[j] +1) {
                    rightDp[i] = rightDp[j] + 1;
                }
            }
        }

        int max = 0;
        for(int i=0; i<n; i++) {
            max = Math.max(max,leftDp[i]+rightDp[i]);
        }
        System.out.println(max-1);
    }
}
