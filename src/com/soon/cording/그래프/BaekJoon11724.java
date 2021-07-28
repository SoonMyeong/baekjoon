package com.soon.cording.그래프;

import java.util.Scanner;

//연결 요소의 개수 (그룹, 즉 간선으로 이어져있는 그룹이 몇개인지 구하는 문제)
public class BaekJoon11724 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int [][] arr = new int[n+1][n+1];
        boolean [] visited = new boolean[n+1];
        int count = 0;

        for(int i=0; i<m; i++) { //간선의 개수
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            arr[u][v] = 1;
            arr[v][u] = 1;
        }

        for(int i=1; i<=n; i++) { // 정점의 개수
            if(!visited[i]) {
                dfs(n,i,arr, visited);
                count++;
            }
        }
        System.out.println(count);
    }

    private static void dfs(int n, int i, int[][] arr, boolean[] visited) {
        visited[i] = true;
        for(int j=1; j<=n; j++) {
            if(!visited[j]&& arr[i][j]==1) {
                dfs(n,j,arr,visited);
            }
        }
    }

}
