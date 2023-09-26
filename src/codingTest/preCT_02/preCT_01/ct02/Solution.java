package codingTest.preCT_02.preCT_01.ct02;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Solution {
    public static int solution(int[] arr) {
        int answer;

        ArrayList<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
        int max = Collections.max(list);
        int min = Collections.min(list);
        list.remove((Integer) max);
        list.remove((Integer) min);

        double average = list.stream().mapToInt(Integer::intValue).average().getAsDouble();
        answer = (int) average;

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {9, 4, 7, 5, 10, 4};
        System.out.println(solution(arr));

    }
}
