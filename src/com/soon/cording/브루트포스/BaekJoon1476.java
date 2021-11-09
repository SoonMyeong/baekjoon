package com.soon.cording.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1476 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int e = Integer.parseInt(arr[0]);
        int s = Integer.parseInt(arr[1]);
        int m = Integer.parseInt(arr[2]);

        int year = 1;

        while(true) {
            if((year-e)%15==0 && (year-s)%28==0 && (year-m)%19 ==0) {
                break;
            }
            year++;
        }

        System.out.println(year);
    }
}
