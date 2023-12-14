package codingTest.CT.CT09.ct01;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//23-12-08(풇이) - 다시 풀기 -  BFS
public class Solution {
    public int solution(int N, int[][] friend, int[][] time) {
        int[] times = new int[N];
        Arrays.fill(times, Integer.MAX_VALUE);
        times[0] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 0; i < friend[current].length; i++) {
                int next = friend[current][i];
                int nextTime = times[current] + time[current][i];
                if (nextTime < times[next]) {
                    times[next] = nextTime;
                    queue.offer(next);
                }
            }
        }

        int answer = Arrays.stream(times).max().getAsInt();
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

}
