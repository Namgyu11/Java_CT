package codingTest.CT.CT19.ct04;
import java.util.*;

//24-02-15(풀이) - 다시 풀기
public class Solution {

  public int solution(int[] param0) {
    int answer = 0;

    // HashSet 생성
    Set<Integer> set = new HashSet<>();

    // 배열의 모든 요소를 HashSet 에 저장
    for(int num : param0) {
      set.add(num);
    }

    // 배열을 다시 순회하면서 현재 요소의 음수 값이 HashSet 에 있는지 확인
    for(int num : param0) {
      if(set.contains(-num)) {
        // 현재 요소와 answer 를 비교하여 더 큰 값을 answer 에 저장
        answer = Math.max(answer, Math.abs(num));
      }
    }

    return answer;
  }
}
