package codingTest.CT.CT06.ct01;


//23-11-17(풀이) - 다시 풀기 - 투포인터
class Solution {
    public int[] solution(int[] values) {
        int start = 0;
        int end = 0;
        int longestStart = 0;
        int longestEnd = 0;

        for (int i = 1; i < values.length; i++) {
            if (values[i] >= values[i - 1]) {
                end = i;
                if (end - start > longestEnd - longestStart) {
                    longestStart = start;
                    longestEnd = end;
                }
            } else {
                start = i;
                end = i;
            }
        }

        return new int[]{longestStart, longestEnd};
    }
}
