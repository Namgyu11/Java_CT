package codingTest.CT.CT_FINAL.ct01;

//24-03-23 다시 풀기
public class Solution {
  public int solution(int[] damages, int shield) {
    int answer = 1;
    for (int damage : damages) {
      int actualDamage = damage - shield;
      if (actualDamage > 0) {
        answer += actualDamage;
      }
    }

    return answer;
  }
}
