package com.soon.cording.그래프;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//반복 수열
public class BaekJoon2331 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int p = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        int num = 0;
        list.add(a);

        while(true) {
            num = parseNumber(a,p);

            if(!list.contains(num)) {
                list.add(num);
            }else {
                System.out.println(list.indexOf(num));
                break;
            }

            a = num;
        }

    }

    private static int parseNumber(int a, int p) {
        int answer =0;
        String number = String.valueOf(a);
        String[] numArr = number.split("");

        for(String num : numArr) {
            int pow = 1;
            for(int i=0; i<p; i++) {
                pow *= Integer.parseInt(num);
            }
            answer+= pow;
        }
        return answer;
    }
}
