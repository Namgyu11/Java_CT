package codingTest.preCT_02.preCT_03_01.ct02.ct03.preCT_03_03.preCT_03_05.ct01;

//23-10-08(풀이) -- 다시 풀기 !!

public class Solution {
    public static int solution(int n) {
        int answer = 0;
        int start = 1;
        int end = 1;
        int sum = 0;

        while (start <= n) {
            if (sum < n) {
                sum += end;
                end++;
            } else if (sum == n) {
                answer++;
                sum -= start;
                start++;
            } else if (sum > n) {
                sum -= start;
                start++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int a = 15;
        System.out.println(solution(a));
    }

}
