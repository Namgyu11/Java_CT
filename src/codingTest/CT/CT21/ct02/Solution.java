package codingTest.CT.CT21.ct02;

public class Solution {
  public boolean solution(String s, String t) {
    if(Math.abs(s.length() - t.length()) > 1)
      return false;

    int diffCount = 0;
    if(s.length() == t.length()) {
      for(int i = 0; i < s.length(); i++) {
        if(s.charAt(i) != t.charAt(i)) diffCount++;
        if(diffCount > 1) return false;
      }
    } else {
      String longer = s.length() > t.length() ? s : t;
      String shorter = s.length() < t.length() ? s : t;
      int i = 0, j = 0;
      while(i < shorter.length() && j < longer.length()) {
        if(shorter.charAt(i) != longer.charAt(j)) {
          diffCount++;
          j++;
        } else {
          i++;
          j++;
        }
        if(diffCount > 1) return false;
      }
      if(j != longer.length()) diffCount++;
    }
    return diffCount == 1;
  }
}
