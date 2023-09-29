package codingTest.preCT_02.preCT_03.ct05;

import java.util.LinkedList;

public class Solution {
    public static int solution(int N, int K) {
        int answer = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N ; i++) {
            list.offer(i);
        }
        while (!list.isEmpty()){
            for (int i = 0; i < K -1; i++) {
                list.offerLast(list.pollFirst());
            }
            list.pollFirst();

            if(list.size() == 1){
                answer = list.peek();
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        System.out.println(solution(n,k));
    }
}
