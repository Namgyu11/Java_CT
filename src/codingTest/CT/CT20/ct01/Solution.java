package codingTest.CT.CT20.ct01;

public class Solution {

  public boolean solution(String s, String t) {
    boolean answer = true;
    String[] s1 = s.split(" ");
    String[] s2 = t.split(" ");

    for (int i = 0; i <s1.length; i++) {
      String a = String.valueOf(s1[i].charAt(0) + s1[i].charAt(s1[i].length() - 1));
      String b = String.valueOf(s2[i].charAt(0) + s2[i].charAt(s2[i].length() - 1));

      if (!a.equals(b)) {
        return false;
      }
    }
    return answer;

  }

}
