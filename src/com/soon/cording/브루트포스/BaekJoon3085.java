package com.soon.cording.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 범위가 작으므로 , 특정 조건을 따지지말고 그냥 전부 다 비교 해 본다.
 */
public class BaekJoon3085 {

    static char[][] arr;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new char[n][n];
        for(int i=0; i<n; i++) {
            char[] temp = br.readLine().toCharArray();
            for(int j=0; j<n; j++) {
                arr[i][j] = temp[j];
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n-1; j++) {
                //열 스위칭
                char temp = arr[i][j];
                arr[i][j] = arr[i][j+1];
                arr[i][j+1] = temp;

                candyCount(n);
                //복구
                temp = arr[i][j];
                arr[i][j] = arr[i][j+1];
                arr[i][j+1] = temp;
                /*----------------------------*/
                temp = arr[j][i];
                arr[j][i] = arr[j+1][i];
                arr[j+1][i] = temp;

                candyCount(n);

                temp = arr[j][i];
                arr[j][i] = arr[j+1][i];
                arr[j+1][i] = temp;
            }
        }
        System.out.println(result);
    }

    private static void candyCount(int n) {
        //열 확인 (줄 마다 체크)
        for(int i=0; i<n; i++) {
            int cnt = 1; //최소 1개는 먹음
            for(int j=0; j<n-1; j++) {
                if(arr[i][j]==arr[i][j+1]) {
                    cnt++;
                }else {
                    result = Math.max(result,cnt);
                    cnt = 1;
                }
            }
            result = Math.max(result,cnt);
        }
        
        //행 확인
        for(int i=0; i<n; i++) {
            int cnt = 1;
            for(int j=0; j<n-1; j++) {
                if(arr[j][i]==arr[j+1][i]) {
                    cnt++;
                }else {
                    result = Math.max(result,cnt);
                    cnt = 1;
                }
            }
            result = Math.max(result,cnt);
        }
    }


}
