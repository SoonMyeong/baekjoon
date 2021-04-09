package com.soon.cording.그리디;

import java.util.Arrays;
import java.util.Scanner;

//주유소
//포인트 : 도시 별 기름 가격을 내림차순
public class BaekJoon13305 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int [] len = new int[n-1];
        int [] price = new int[n];

        for(int i=0; i<n-1; i++){
            len[i] = scanner.nextInt();
        }
        for(int i=0; i<n; i++){
            price[i] = scanner.nextInt();
        }

        long result = 0;
        long minPrice = price[0];

        for(int i=0; i<n-1; i++){
            if(minPrice>price[i]){
                minPrice = price[i];
            }
            result += minPrice * len[i];
        }

        System.out.println(result);

    }
}
