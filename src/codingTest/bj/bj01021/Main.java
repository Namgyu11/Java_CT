package codingTest.bj.bj01021;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> deque = new LinkedList();

        int count = 0;
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] seq = new int[M];

        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        for (int i = 0; i < M; i++) {
            seq[i] = sc.nextInt();
        }

        //인덱스 찾기
        for (int i = 0; i < M; i++) {
            int target_idx = deque.indexOf(seq[i]);
            int half_idx;

            if (deque.size() % 2 == 0) {
                half_idx = deque.size() / 2 - 1;
            } else {
                half_idx = deque.size() / 2;
            }

            //2번
            if (target_idx <= half_idx) {
                for (int j = 0; j < target_idx; j++) {
                    int temp = deque.pollFirst();
                    deque.offerLast(temp);
                    count++;
                }
            } else {
                //3번
                for (int k = 0; k < deque.size() - target_idx; k++) {
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                    count++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(count);
    }
}
