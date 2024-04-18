package codingTest.CT.CT_FINAL.ct02;

//24-03-23 다시 풀기 -  브루트포스
public class Solution {
  public int solution(String[] words) {
    int answer = 0;

    for (int i = 0; i < words.length; i++) {
      for (int j = 0; j < words.length; j++) {
        if (i != j) {
          String combined = words[i] + words[j];
          if (isPalindrome(combined)) {
            answer++;
          }
        }
      }
    }

    return answer;
  }

  private boolean isPalindrome(String word) {
    int left = 0;
    int right = word.length() - 1;

    while (left < right) {
      if (word.charAt(left) != word.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }

    return true;
  }
}
