package codingTest.preCT_02.preCT_03_01.ct05.표현가능한이진트리.연속펄스부분수열의합.preCT_03_02.preCT_03_03.ct03;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Solution {
    public static int solution(int[] A) {
        int answer = 0;
        LinkedList<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toCollection(LinkedList::new));
        Collections.sort(list);

        int[] dp = new int[A.length + 1];

        if (!list.isEmpty()) {
            if(A.length % 2 != 0){
                dp[A.length] = list.pollLast();
                dp[A.length - 1] = list.pollFirst();
            }else {
                dp[A.length] = list.pollFirst();
                dp[A.length - 1] = list.pollLast();
            }
            for (int i = dp.length-3; i >= 1; i--) {
                if(!list.isEmpty()) {
                    if (i % 2 != 0) {
                        dp[i] = list.pollLast();
                    } else {
                        dp[i] = list.pollFirst();
                    }
                }
            }
        }

        for (int i = 1; i < dp.length; i++) {
            if(i % 2 != 0){
                answer+= dp[i] * i;
            }else {
                answer += dp[i] * -i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5,6};
        System.out.println(solution(a));
    }
}
