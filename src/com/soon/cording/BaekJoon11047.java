package com.soon.cording;

import java.util.Scanner;

public class BaekJoon11047 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int money = scan.nextInt();

        int [] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = scan.nextInt();
        }

        // 주석 한 방식대로 해도 결과 시간은 같음
        int result = 0;
        //int temp = 0;
        for(int i = arr.length-1; i>=0; i--) {
            //temp = money % arr[i];
          //  if(temp != money){
            if(arr[i] <= money) {
                result += money / arr[i];
                money = money % arr[i];
            }
        }
        System.out.println(result);

    }
}
