package codingTest.CT.CT19.ct01;


//24-02-15 다시 풀기
public class Solution {

  public boolean solution1(String s, String t) {
    boolean answer = false;
    for (int i = 0; i < s.length(); i++) {
      if (s.equals(t)) {
        return true;
      }
      s = s.substring(s.length() - 1) + s.substring(0, s.length() - 1);
    }
    return answer;
  }

  public boolean solution(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    String sTwice = s + s;
    return sTwice.indexOf(t) != -1;
  }
}
