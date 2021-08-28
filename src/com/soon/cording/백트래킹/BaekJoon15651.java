package com.soon.cording.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 만약 arr 의 값이 자연수 순서대로가 아닌 주어진 대로 해결 해야 한다면?
 * -> 임시 배열 만들어서 풀면 됨
 */
public class BaekJoon15651 {

    public static int[] arr;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());

        int n = 4; int m = 2;

        arr = new int[4];
        int[] temp = new int[4];
        for(int i=0; i<arr.length; i++) {
            arr[i] = i+1;
        }

        combination(n,m,0,temp);
    }

    private static void combination(int n, int m, int depth, int[] temp) {
        if(depth==m) {
            for(int i=0; i<m; i++) {
                System.out.print(temp[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<n; i++) {
            temp[depth] = arr[i];
            combination(n,m,depth+1,temp);
        }

    }
}
