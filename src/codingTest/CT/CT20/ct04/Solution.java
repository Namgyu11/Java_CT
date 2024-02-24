package codingTest.CT.CT20.ct04;
import java.util.*;

//24-02-23 (풀이) 다시 풀기 -- 재귀, 백트래킹
public class Solution {

  char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};

  public String[] solution(int n) {
    List<String> result = new ArrayList<>();
    char[] cur = new char[n];
    generateStrobogrammaticNumbers(cur, result, 0, n - 1);
    return result.toArray(new String[0]);
  }

  private void generateStrobogrammaticNumbers(char[] cur, List<String> result, int low, int high) {
    if (low > high) {
      if (cur.length == 1 || cur[0] != '0') {
        result.add(new String(cur));
      }
      return;
    }

    for (char[] pair : pairs) {
      cur[low] = pair[0];
      cur[high] = pair[1];
      if (low == high && pair[0] != pair[1]) {
        continue;
      }
      generateStrobogrammaticNumbers(cur, result, low + 1, high - 1);
    }
  }

}
