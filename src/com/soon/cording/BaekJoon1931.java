package com.soon.cording;

import java.util.Arrays;
import java.util.Scanner;

//문제 : 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자.
//문제 핵심 : 서로 겹치지 않는 시간들 사이에서 종료 시간이 짧을 수록 더 많은 회의를 할 수 있음
public class BaekJoon1931 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int [][] arr = new int[n][2];

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<2; j++){
                arr[i][j] = scan.nextInt();
            }
        }

        //회의 종료 시간 순으로 오름차순 정렬, 단 종료 시간이 같을 경우 시작 시간이 더 빠른값 (작은 값) 으로 정렬
        // 4 ,5 , 6 ,7 ,8, 9, 10 ,11 ..
        Arrays.sort(arr,(o1, o2) -> {
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int previousTime = 0; //이전 시간
        int result = 0; //결과

        for(int i=0; i<n; i++){
            // 배열을 순회 하면서 직전 종료 시간이 다음 회의 시작시간 보다 작으면 갱신
            if(previousTime <= arr[i][0]) {
                previousTime = arr[i][1];
                result++;
            }
        }

        System.out.println(result);
    }
}
