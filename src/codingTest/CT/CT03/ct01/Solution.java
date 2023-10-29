package codingTest.CT.CT03.ct01;

import java.util.*;

//23-10-26(풀이) - 다시 풀어 보기
public class Solution {
    public static int solution(int N, int[][] trust) {

        HashMap<Integer, Integer> trustCount = new HashMap<>();
        HashSet<Integer> trustOthers = new HashSet<>();

        for (int[] relation : trust) {
            trustCount.put(relation[1], trustCount.getOrDefault(relation[1], 0) + 1);
            trustOthers.add(relation[0]);
        }

        for (int i = 1; i <= N; i++) {
            if (trustCount.getOrDefault(i, 0) == N - 1 && !trustOthers.contains(i)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int N = 3;
        int[][] tr = {{1, 2}, {1, 4}, {1, 3}, {2, 1}, {4, 3}};

        System.out.println();
        System.out.println(solution(N, tr));

    }
}
