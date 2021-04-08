package com.soon.cording.그리디;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

//잃어버린 괄호
//포인트 : 기호 다음 자리의 숫자가 최대한 큰수가 되도록 괄호를 친다.
//ex) 55-50+40  =>  55-(50+40) = -35
public class BaekJoon1541 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.next();

        String [] sp = in.split("-");
        AtomicInteger result = new AtomicInteger(0);

        AtomicInteger k = new AtomicInteger(0);

        Arrays.stream(sp).forEach(s->{
            String [] temp = s.split("\\+");
            int sum = Arrays.stream(temp)
                    .mapToInt(Integer::parseInt)
                    .sum();
            if(k.get() ==0){
                result.set(sum);
            }else{
                result.set(result.get() - sum);
            }
            k.getAndIncrement();
        });

        // 일반 방식
//        for(int i=0; i<sp.length; i++){
//            String [] temp = sp[i].split("\\+");
//            int sum = Arrays.stream(temp)
//                    .mapToInt(Integer::parseInt)
//                    .sum();
//
//            if(i==0){
//                result.set(sum);
//            }else{
//                result.set(result.get() - sum);
//            }
//        }

        System.out.println(result.get());

    }
}
