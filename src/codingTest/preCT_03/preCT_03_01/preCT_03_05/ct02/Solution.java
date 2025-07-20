package codingTest.preCT_03.preCT_03_01.preCT_03_05.ct02;

//23-10-08(풀이) -- 다시 풀기 !!

public class Solution {
    public static int solution(int N, int K) {
        String numStr = Integer.toString(N);
        boolean isNegative = false;

        if (N < 0) {
            isNegative = true;
            numStr = numStr.substring(1);
        }

        for (int i = 0; i < numStr.length(); i++) {
            int digit = Character.getNumericValue(numStr.charAt(i));

            if ((isNegative && digit > K) || (!isNegative && digit < K)) {
                String result = numStr.substring(0, i) + Integer.toString(K) +
                        numStr.substring(i);
                return Integer.parseInt(isNegative ? "-" + result : result);
            }
        }

        return Integer.parseInt(numStr + Integer.toString(K));
    }

    public static void main(String[] args) {
        System.out.println(solution(278,3));
    }
}
// -654  6