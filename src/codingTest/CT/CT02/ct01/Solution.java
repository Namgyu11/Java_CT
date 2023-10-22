package codingTest.CT.CT02.ct01;

import java.util.Arrays;

public class Solution {
    public static int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        int min = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == min){
                min++;
            }else {
                if(i != 0){
                    return numbers[i-1] + 1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        System.out.println(solution(new int[]{26, 62, 34, 52, 15, 17, 16, 20, 19, 18}));
    }

}
