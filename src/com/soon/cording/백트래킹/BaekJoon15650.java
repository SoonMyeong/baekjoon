package com.soon.cording.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon15650 {
    public static int[] arr;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];

        for(int i=0; i<arr.length; i++) {
            arr[i] = i+1;
        }
        combination(n,m,0);

    }

    private static void combination(int n, int m, int start) {
        if(m == 0) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    System.out.print(arr[i]+ " ");
                }
            }
            System.out.println();
            return;
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            combination(n,m-1,i+1);
            visited[i] = false;
        }
    }
}
