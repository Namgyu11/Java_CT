package codingTest.CT.CT02.ct05;

//23-10-22(풀이) - 다시 풀기(슬라이딩 윈도우)
public class Solution {
    public int[][] solution(int[][] image, int K) {
        int height = image.length; // 이미지의 높이
        int width = image[0].length; // 이미지의 너비
        int offset = K / 2; // 주변 픽셀을 계산하기 위한 오프셋 값

        // 결과를 저장할 배열 초기화 (입력 이미지와 동일한 크기)
        int[][] result = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                // 평균 계산을 위한 합계 초기화
                double sum = 0;

                // 주변 픽셀 순회
                for (int m = -offset; m <= offset; m++) {
                    for (int n = -offset; n <= offset; n++) {

                        // 원본 이미지에서 이웃 픽셀의 좌표 계산
                        int y = i + m;
                        int x = j + n;

                        // 원본 이미지 범위 내에 있으면 합계에 추가
                        if (y >= 0 && y < height && x >= 0 && x < width) {
                            sum += image[y][x];
                        }
                    }
                }

                // 평균 계산 후 결과 배열에 할당. Math.floor를 사용하여 소수점 아래 버림.
                result[i][j] = (int)Math.floor(sum / (K * K));
            }
        }

        return result;
    }
}
