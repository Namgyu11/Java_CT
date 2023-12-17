package codingTest.CT.CT_month_02.ct01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public static int solution(int N, int[] selected, int[][] lottos) {
        int answer = 0;
        Set<Integer> set = Arrays.stream(selected).boxed().collect(Collectors.toSet());

        for (int i = 0; i < N; i++) {
            if(set.equals(Arrays.stream(lottos[i]).boxed().collect(Collectors.toSet()))) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        int[] se = {1, 7, 8, 24, 5, 16};
        int[][] lo = {{1, 7, 8, 24, 5, 16}, {16, 5, 1, 7, 8, 24}, {1, 7, 8, 24, 5, 15}};
        System.out.println( solution(n,se,lo));
    }
}
