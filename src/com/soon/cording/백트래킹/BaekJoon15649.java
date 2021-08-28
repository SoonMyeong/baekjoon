package com.soon.cording.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//N 과 M (1)
public class BaekJoon15649 {
    public static int[] arr;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[m]; //선택된 숫자들을 담아 두는 배열
        visited = new boolean[n]; //N까지 순회하면서 방문여부 체킹하는 배열

        dfs(n,m,0);

    }

    private static void dfs(int n, int m, int depth) {
        if(depth == m) {
            Arrays.stream(arr).forEach(x->System.out.print(x+" "));
            System.out.println();
        }else {
            for(int i=0; i<n; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    arr[depth] = i+1;
                    dfs(n,m,depth +1);
                    visited[i] = false; //현재 i값에 따른 depth 순회가 끝났으면 다시 리셋해 줘야 다음 i 값에 대해서도
                                        // 순회를 할 수 있다.
                }
            }
        }
    }
}
