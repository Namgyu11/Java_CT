package codingTest.CT.CT_month_05.ct02;
import java.util.*;

//22-02-16(풀이) 조합 - 백트래킹
public class Solution {

  public int solution(int N, int K, int M, int[] arr) {
    int answer = 0;
    Arrays.sort(arr);
    for (int i = 1; i <= K; i+=2) {
      answer += combinationCount(arr, N, i, M);
    }
    return answer;
  }

  private int combinationCount(int[] arr, int n, int r, int M) {
    int[] comb = new int[r];
    return combination(arr, comb, 0, n, r, 0, M);
  }

  private int combination(int[] arr, int[] comb, int index, int n, int r, int target, int M) {
    if (r == 0) {
      int sum = 0;
      for (int i : comb) {
        sum += i;
      }
      if (sum >= M) {
        return 1;
      } else {
        return 0;
      }
    } else if (target == n) {
      return 0;
    } else {
      comb[index] = arr[target];
      return combination(arr, comb, index + 1, n, r - 1, target + 1, M) +
          combination(arr, comb, index, n, r, target + 1, M);
    }
  }
}
