package codingTest.CT.CT_FINAL.ct10;

import java.util.*;

//24-03-23 다시 풀기 --
public class Solution {
    public int[][] solution(int[][] matrix) {
        Set<Integer> set = new HashSet<>();
        for (int[] row : matrix) {
            for (int num : row) {
                set.add(num);
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(set);
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        while (!queue.isEmpty()) {
            map.put(queue.poll(), rank++);
        }

        int[][] answer = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                answer[i][j] = map.get(matrix[i][j]);
            }
        }

        return answer;
    }
}