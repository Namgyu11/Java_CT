package codingTest.preCT_02.preCT_03.ct02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static int[] solution(int[] nums) {
        int[] answer = {};

        ArrayList<Integer> list = Arrays.stream(nums).boxed().
                collect(Collectors.toCollection(ArrayList::new));
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i <list.size(); i++) {
            if(!list.contains(i+1)){
                list1.add(i+1);
            }
        }

        answer = list1.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,6,6,6};


    }
}
