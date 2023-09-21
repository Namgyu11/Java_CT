package codingTest.preCT_01.preCT_02.ct05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static int solution(int[] arr) {
        int answer = Arrays.stream(arr).min().getAsInt();

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {5,2,1,3};
        System.out.println(arr);
    }
}
