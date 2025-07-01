package codingTest.preCT_03.preCT_03_01.표현가능한이진트리.N으로_표현;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(int N, int number) {
        if (N == number) {
            return 1;
        }
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }
        int concat = 0;
        for (int i = 1; i <= 8; i++) {
            concat = concat * 10 + N;
            dp.get(i).add(concat);
        }
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i - j)) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(b - a);
                        dp.get(i).add(a * b);
                        if (b != 0) {
                            dp.get(i).add(a / b);
                        }
                        if (a != 0) {
                            dp.get(i).add(b / a);
                        }
                    }
                }
            }
            if (dp.get(i).contains(number)) {
                return i;
            }
        }
        return -1;
    }
}
