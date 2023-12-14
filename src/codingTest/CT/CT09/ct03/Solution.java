package codingTest.CT.CT09.ct03;


//23-12-08(풇이) - 다시 풀기 -
class Solution {
    public int solution(int N, int[][] graph, int[] infected) {
        int answer = 0;
        int minInfections = Integer.MAX_VALUE;

        // 치료 후 감염자 수가 최소인 인원을 찾기 위해 감염자를 하나씩 치료해보고 확인합니다.
        for (int i = 0; i < infected.length; i++) {
            // 현재 감염자를 치료하기 전의 감염자 수를 세어줍니다.
            int infectionsBeforeCure = countInfections(graph, infected);

            // 현재 감염자를 치료합니다.
            graph[infected[i]][infected[i]] = 0;

            // 현재 감염자를 치료한 후의 감염자 수를 세어줍니다.
            int infectionsAfterCure = countInfections(graph, infected);

            // 치료 후 감염자 수가 최소인 경우, 정답을 갱신합니다.
            if (infectionsAfterCure < minInfections) {
                minInfections = infectionsAfterCure;
                answer = infected[i];
            }

            // 감염자를 다시 되돌려놓습니다.
            graph[infected[i]][infected[i]] = 1;
        }

        return answer;
    }

    // 주어진 그래프에서 현재 감염된 인원 수를 세어줍니다.
    private int countInfections(int[][] graph, int[] infected) {
        int count = 0;
        for (int i = 0; i < infected.length; i++) {
            if (graph[infected[i]][infected[i]] == 1) {
                count++;
            }
        }
        return count;
    }
}
