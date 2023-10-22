package codingTest.CT.CT02.ct04;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // [2, 2, 0, 4, 2, 3, 0, 0, 1, 2, 5, 0, 3, 4, 0]
    //[3, 2, 0, 0, 2, 3, 0, 0, 2, 2, 5]
    public static int solution(int delay, int capacity, int[] times) {
        int answer = 0;
        int time = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < times.length; i++) {
            time += times[i];
            if(delay <= time && !queue.isEmpty()){
                queue.remove();
                time = time - delay;
            }
            if(queue.size() < capacity){
                queue.add(1);
            }else {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int delay = 3;
        int capacity = 5;
        int[] times = {2, 2, 0, 4, 2, 3, 0, 0, 1, 2, 5, 0, 3, 4, 0};
        System.out.println(solution(delay,capacity,times));
    }
}
