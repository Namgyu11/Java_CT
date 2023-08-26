package codingTest.preCT.ct07.ct07_05;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int N, int K) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            queue.add(i);
        }

        while (queue.size() > 1){
            for (int i = 0; i < K-1; i++) {
                queue.add(queue.remove());
            }
            queue.remove();
        }
        answer = queue.peek();
        return answer;
    }

    public static void main(String[] args) {
        int a = 7;
        int b = 3;
    }
}
