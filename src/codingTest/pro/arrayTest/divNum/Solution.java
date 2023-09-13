package codingTest.pro.arrayTest.divNum;

import java.util.ArrayList;
import java.util.Collections;
/*
프로그래머스
연습문제
나누어 떨어지는 숫자 배열

* */
public class Solution {
    public static int[] solution(int[] arr, int divisor) {
        int[] answer;
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int num : arr){
            if(num % divisor == 0){
                arrayList.add(num);
            }
        }
        if(arrayList.size() == 0){
            arrayList.add(-1);
        }
        Collections.sort(arrayList);

        answer = arrayList.stream().mapToInt( i -> i).toArray();

        return answer;
    }
}
