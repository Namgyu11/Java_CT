package codingTest.preCT_02.preCT_01.ct01;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static int solution(int[] arr) {
        int answer = 0;
        LinkedList<Integer> list = Arrays.stream(arr).boxed().sorted().collect(Collectors.toCollection(LinkedList::new));

        while(!list.isEmpty()){
            int temp1 = list.pollLast();
            if(list.size() > 2) {
                int temp2 = list.peekLast();
                int temp3 = list.get(list.indexOf(temp2) -1);
                if (temp1 < temp2 + temp3) {
                    answer = temp1 + temp2 + temp3;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] arr ={1,2,4,60,50,7};
        System.out.println(solution(arr));
    }
}
