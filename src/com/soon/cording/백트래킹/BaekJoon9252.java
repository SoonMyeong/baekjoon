package com.soon.cording.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//LCS 2
public class BaekJoon9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strOne = br.readLine();
        String strTwo = br.readLine();

        String[] one = strOne.split(""); //가로
        String[] two = strTwo.split(""); //세로
        int[][] arr = new int[one.length+1][two.length+1];

        for(int i=1; i<=one.length; i++) {
            for(int j=1; j<=two.length; j++) {

                if(two[j-1].equals(one[i-1])) {
                    arr[i][j] = arr[i-1][j-1] +1;
                }else {
                    arr[i][j] = Math.max(arr[i-1][j],arr[i][j-1]);
                }

            }
        }
        System.out.println(arr[one.length][two.length]);

        StringBuilder sb = new StringBuilder();

        traceString(arr,one,two, one.length, two.length, sb);

        System.out.println(sb.reverse());

    }
    public static void traceString(int[][] arr, String[] one, String[] two, int i, int j, StringBuilder sb) {
        if(arr[i][j]==0) {
            return;
        }
        if(one[i-1].equals(two[j-1])) {
            sb.append(one[i-1]);
            traceString(arr,one,two,i-1,j-1,sb);
        }else {
            if (arr[i - 1][j] > arr[i][j - 1]) {
                traceString(arr, one, two, i - 1, j, sb);
            } else {
                traceString(arr, one, two, i, j - 1, sb);
            }
        }
    }
}
