package com.soon.cording.그래프;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 이분 그래프.. ;;
 */
public class BaekJoon1707 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> result = new ArrayList<>();
        int k = scanner.nextInt();

        for(int i=0; i<k; k++) {
            int v = scanner.nextInt();
            int e = scanner.nextInt();
            List<List<Integer>> list = new ArrayList<>();
            int[] color = new int[v+1];

            for(int j=0; j<v; j++) {
                list.add(new ArrayList<>());
            }

            for(int j=0; j<e; j++) {
                int n = scanner.nextInt();
                int m = scanner.nextInt();
                list.get(n).add(m);
                list.get(m).add(n);
            }

            for(int j = 1; j<=v; j++) {

            }

            if(isBipartiteGraph(v,list,color)) {
                result.add("YES");
            }else {
                result.add("NO");
            }
        }
        result.forEach(System.out::println);
    }

    private static boolean isBipartiteGraph(int v, List<List<Integer>> list, int[] color) {
        return true;
    }

}
