package com.soon.cording.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaekJoon2309 {

    static boolean[] visited;
    static int[] arr ;
    static List<Integer> result;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9];
        result = new ArrayList<>();
        visited = new boolean[9];

        for(int i=0; i<9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dfs(0,0);

    }

    private static void dfs(int n, int count) {
        if(count==7) {
            sum = result.stream().reduce(0,Integer::sum);
            if(sum ==100) {
                Collections.sort(result);
                result.forEach(System.out::println);
                return;
            }
        }

        for(int i=n; i<9; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result.add(arr[i]);
                dfs(i+1,count+1);
                result.remove(result.size()-1);
                visited[i] = false;
            }
        }
    }
}
