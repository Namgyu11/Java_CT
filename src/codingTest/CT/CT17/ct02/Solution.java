package codingTest.CT.CT17.ct02;

import java.util.*;
//24-02-01 (풀이) 다시 풀기 - 게임이론 - 그리디 알고리즘
public class Solution {

  public int solution(int[][] value) {
    // 돌을 첫 번째 플레이어와 두 번째 플레이어 간의 가치 차이에 따라 정렬
    Arrays.sort(value, (a, b) -> (b[0] - b[1]) - (a[0] - a[1]));

    int score1 = 0, score2 = 0;
    for(int i = 0; i < value.length; i++) {
      if(i % 2 == 0) {
        score1 += value[i][0];
      } else {
        score2 += value[i][1];
      }
    }

    // 최종 점수를 비교하여 결과를 반환
    if(score1 > score2) {
      return 1;
    } else if(score1 < score2) {
      return -1;
    } else {
      return 0;
    }
  }

}
