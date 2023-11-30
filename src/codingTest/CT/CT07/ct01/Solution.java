package codingTest.CT.CT07.ct01;


//23-11-24(풀이) - @@다시 풀어보기@@ - 분할 정복 알고리즘
public class Solution {
    public String solution(int[][] img) {
        return compress(img, 0, 0, img.length);
    }

    private String compress(int[][] img, int x, int y, int len) {
        if (len == 1) {
            return Integer.toString(img[x][y]);
        }

        int half = len / 2;
        String topLeft = compress(img, x, y, half);
        String topRight = compress(img, x, y + half, half);
        String bottomLeft = compress(img, x + half, y, half);
        String bottomRight = compress(img, x + half, y + half, half);

        if (topLeft.equals(topRight) && topRight.equals(bottomLeft) && bottomLeft.equals(bottomRight)) {
            return topLeft;
        } else {
            return "(" + topLeft + topRight + bottomLeft + bottomRight + ")";
        }
    }
}
