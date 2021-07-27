package com.soon.cording.그래프;

import java.util.*;

/**
 * DFS & BFS 구현
 * 오랜만에 다시 풀려니 기억 거의 안남... 다시 정리!
 */
public class BaekJoon1260 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int v = scanner.nextInt();

        int [][]arr = new int[n+1][n+1];
        boolean[] visited = new boolean[n+1];


        for(int i=0; i<m; i++) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            arr[row][col] = 1;
            arr[col][row] = 1;
        }

        dfs(n,v,arr,visited);
        visitedReset(n,visited);
        bfs(n,v,arr,visited);
    }


    private static void visitedReset(int n, boolean[] visited) {
        for(int i=1; i<=n; i++) {
            visited[i] = false;
        }
        System.out.println();
    }

    private static void dfs(int n, int v, int[][] arr, boolean[] visited) {
        visited[v] = true;
        System.out.print(v+" ");
        for(int i=1; i<=n; i++) {
            if(!visited[i] && arr[v][i] ==1) {
                dfs(n,i,arr,visited);
            }
        }
    }

    private static void bfs(int n, int v, int[][] arr, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;

        while(!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.print(temp+" ");

            for(int i=1; i<=n; i++) {
                if(arr[temp][i]==1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }

        }

    }
}
