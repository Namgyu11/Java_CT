package codingTest.CT.CT_month_05.ct01;


//24-02-16(풀이)
public class Solution {

  public static long solution(int N, int K, int[] arr) {
    long answer = 0;
    for (int i = 0; i < K; i++) {
      answer += arr[i] * 2;
    }

    for (int i = K; i < N; i++) {
      if (i == K) {
        answer += arr[i];
      } else {
        answer += arr[i] - arr[i - 1];
      }

    }

    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution(6, 3, new int[]{3, 7, 10, 12, 15, 19}));
  }

}
