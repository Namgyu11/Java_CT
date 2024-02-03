package codingTest.CT.CT17.ct03;
//24-02-01 (풀이) 다시 풀기 - 게임이론 - ???

public class Solution {

  public int[][] solution(int M, int N, int[][] shapes, int[] colors) {
    int[][] answer = new int[M][N];

    // 각 원에 대해
    for(int i = 0; i < shapes.length; i++) {
      int centerX = shapes[i][0];
      int centerY = shapes[i][1];
      int radius = shapes[i][2];

      // 모든 픽셀에 대해
      for(int y = 0; y < M; y++) {
        for(int x = 0; x < N; x++) {
          // 현재 픽셀이 원 내부에 있는지 확인
          if(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2) <= Math.pow(radius, 2)) {
            // 원 내부에 있으면 해당 원의 색상으로 채움
            answer[y][x] = colors[i];
          }
        }
      }
    }

    return answer;
  }
}
