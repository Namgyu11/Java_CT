package codingTest.CT.CT03.ct03;

//23-10-27(풀이) -- 다시 풀기
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int delay, int N) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int count = 1;
        for (int i = 1; i <= N; i++) {
            Queue<Integer> newQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                int d = queue.remove();
                if (d == 0) {
                    newQueue.add(0);
                    newQueue.add(delay);
                    count += 2;
                } else {
                    newQueue.add(d - 1);
                }
            }
            queue = newQueue;
        }
        return count;
    }
}
