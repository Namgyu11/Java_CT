package codingTest.CT.CT05.ct02;

import java.util.Arrays;

public class Solution {
    public String solution(int[] numbers) {
        String[] strNum = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            strNum[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strNum, ((o1, o2) -> -(o1 + o2).compareTo(o2 + o1)));

        String answer = String.join("",strNum);
        return answer;
    }

}
