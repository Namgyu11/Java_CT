package codingTest.CT.CT18.ct03;
//24-02-09 (풀이) 다시 풀기 -- 벡터의 외적
public class Solution {

  public String solution(int[][] points) {
    int crossProduct = (points[1][0] - points[0][0]) * (points[2][1] - points[0][1]) - (points[2][0] - points[0][0]) * (points[1][1] - points[0][1]);

    if (crossProduct > 0) {
      return "CCW";
    } else if (crossProduct < 0) {
      return "CW";
    } else {
      return "LINE";
    }
  }

}
