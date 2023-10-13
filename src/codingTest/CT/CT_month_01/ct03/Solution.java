package codingTest.CT.CT_month_01.ct03;
//22-10-13(풀이) 다시 풀기
//완전 탐색 알고리즘

import java.util.*;

class Solution {
    int N;
    int K;
    int[] arr;
    List<List<Integer>> groups = new ArrayList<>();
    boolean[] visited;
    int answer = Integer.MAX_VALUE;

    public int solution(int N, int K, int[] arr) {
        this.N = N;
        this.K = K;
        this.arr = arr;

        for (int i=0; i<K; i++) {
            groups.add(new ArrayList<>());
        }

        visited = new boolean[N];

        divide(0);

        return answer;
    }


    private void divide(int idx) {
        if (idx == N) {
            calculate();
            return;
        }

        for (int i=0; i<K; i++) {
            groups.get(i).add(arr[idx]);
            divide(idx+1);
            groups.get(i).remove(groups.get(i).size()-1);
        }
    }

    private void calculate() {
        for (List<Integer> group : groups) {
            if (group.size() == 0) return;
        }

        int minPower = Integer.MAX_VALUE;
        int maxPower = Integer.MIN_VALUE;


        for (List<Integer> group : groups) {
            int sumOfScores = 0;

            for (int score : group) {
                sumOfScores += score * group.size();
            }


            minPower=Math.min(minPower,sumOfScores);
            maxPower=Math.max(maxPower,sumOfScores);
        }

        answer=Math.min(answer,maxPower-minPower);
    }

    public static void main(String[] args) {

    }
}

