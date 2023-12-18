package codingTest.CT.CT_month_03.ct01;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public int solution(int N, int[] scores) {

        int max = Arrays.stream(scores).max().getAsInt();
        int min = Arrays.stream(scores).min().getAsInt();

        return max - min;
    }

}
