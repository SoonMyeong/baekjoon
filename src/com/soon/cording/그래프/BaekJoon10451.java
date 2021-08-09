package com.soon.cording.그래프;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//순열 사이클
public class BaekJoon10451 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> result = new ArrayList<>();
        int total = scanner.nextInt();
        for(int i=0; i<total; i++) {
            int n = scanner.nextInt();
            int[][] arr = new int[n+1][n+1];
            boolean[] visited = new boolean[n+1];

            for(int j=1; j<=n; j++) { // 간선의 개수
                int number = scanner.nextInt();
                arr[j][number] = 1;
                arr[number][j] = 1;
            }
            int count = 0;
            for(int k=1; k<=n; k++) { // 정점의 개수
                if(!visited[k]) {
                    dfs(n,k,arr,visited);
                    count++;
                }
            }
            result.add(count);
        }
        result.forEach(System.out::println);
    }

    private static void dfs(int n, int k, int[][] arr, boolean[] visited) {
        visited[k] = true;
        for(int i=1; i<=n; i++) {
            if(!visited[i] && arr[k][i]==1) {
                dfs(n,i,arr,visited);
            }
        }
    }
}
