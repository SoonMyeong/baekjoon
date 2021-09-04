package com.soon.cording.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon15652 {

    public static int[] arr;

    /**
     * 11
     * 12
     * 13
     * 14
     * 22
     * 23
     * 24
     * 33
     * 34
     * 44
     *
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[m]; //m개만 뽑을거니까 m개 공간으로 셋팅
        combination(n,m,1,0);

    }

    private static void combination(int n, int m,int start, int depth) {
        if(depth==m) {
            for(int i : arr) {
                System.out.print(i+ " ");
            }
            System.out.println();
            return;
        }

        for(int i=start; i<=n; i++) {
            arr[depth] = i;                         //1          //2   //3 //4
            combination(n,m, i,depth+1);    //1,2,3,4    //2,3,4//3,4,//4
        }

    }
}
