package codingTest.CT.CT19.ct02;


//24-02-15(풀이) - 다시 풀기

public class Solution {

  public boolean solution(String param0) {
    if(param0.length() < 5) {
      return false;
    }

    boolean hasDigit = false;
    boolean hasUpper = false;

    for(int i = 0; i < param0.length(); i++) {
      char ch = param0.charAt(i);

      if(Character.isDigit(ch)) {
        hasDigit = true;
      }

      if(Character.isUpperCase(ch)) {
        hasUpper = true;
      }
    }

    return hasDigit && hasUpper;
  }

}
