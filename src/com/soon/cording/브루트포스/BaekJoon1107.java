package com.soon.cording.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1107 {

    /**
     * 브루트포스 의 한 문제. 쉽게 생각해서
     * 초기값으로 +, -로만 채널에 이동할 때 누르는 버튼 횟수 (최대 횟수) 를 구한 뒤
     * 1부터 문제나 나온 최대값 (500,000 근데 9번 버튼 하나 뺴고 다 고장날 경우엔 9를 6번 눌러야 하므로 999,999 가 최대값이 된다.)
     * 까지 숫자버튼과 +,- 버튼을 누른 값의 횟수 중 최소값을 계속 비교하면서 찾는다. (처음부터 끝까지 싹 다 비교, 부르트포스임)
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int brokenCount = Integer.parseInt(br.readLine());

        boolean[] broken = new boolean[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < brokenCount; i++) {
            int num = Integer.parseInt(st.nextToken());
            broken[num] = true;
        }

        int result = Math.abs(target - 100); //초기값 , 현재 채널 100
        for(int i=0; i<=999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();

            boolean isBreak = false;
            for(int j=0; j<len; j++) {
                if(broken[str.charAt(j) - '0']) {
                    isBreak = true;
                    break;
                }
            }

            if(!isBreak) {
                int min = Math.abs(target - i) + len;
                result = Math.min(min,result);
            }
        }
        System.out.println(result);
    }
}
