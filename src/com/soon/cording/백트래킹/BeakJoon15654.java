package com.soon.cording.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BeakJoon15654 {
    static boolean[] visited;
    static int[] input;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        visited = new boolean[n];
        arr = new int[n];
        input = new int[n];

        temp = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            input[i] = Integer.parseInt(temp[i]);
        }
        Arrays.sort(input);

        dfs(n,m,0);


    }

    private static void dfs(int n, int m, int depth) {
        if(depth==m) {
            for(int i=0; i<m; i++) {
                    System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = input[i];
                dfs(n, m, depth + 1);
                visited[i] = false;
            }
        }

    }
}
