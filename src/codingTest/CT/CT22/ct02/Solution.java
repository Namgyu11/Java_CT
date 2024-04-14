package codingTest.CT.CT22.ct02;
import java.util.*;

// 24-03-07 (풀이) 다시 풀기 --
public class Solution {
  public int[][] solution(int[][] s, int[][] t) {
    List<Integer> s_decoded = decode(s);
    List<Integer> t_decoded = decode(t);
    List<Integer> u_decoded = new ArrayList<>();

    for (int i = 0; i < s_decoded.size(); i++) {
      u_decoded.add(s_decoded.get(i) * t_decoded.get(i));
    }

    return encode(u_decoded);
  }

  private List<Integer> decode(int[][] encoded) {
    List<Integer> decoded = new ArrayList<>();

    for (int[] pair : encoded) {
      for (int i = 0; i < pair[1]; i++) {
        decoded.add(pair[0]);
      }
    }

    return decoded;
  }

  private int[][] encode(List<Integer> decoded) {
    List<int[]> encoded = new ArrayList<>();
    int count = 1;

    for (int i = 1; i < decoded.size(); i++) {
      if (decoded.get(i).equals(decoded.get(i - 1))) {
        count++;
      } else {
        encoded.add(new int[] {decoded.get(i - 1), count});
        count = 1;
      }
    }

    encoded.add(new int[] {decoded.get(decoded.size() - 1), count});

    return encoded.toArray(new int[encoded.size()][]);
  }

}
