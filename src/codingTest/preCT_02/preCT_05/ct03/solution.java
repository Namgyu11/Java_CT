package codingTest.preCT_02.preCT_05.ct03;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class solution {
    public static int solution(int[] cards) {
        int answer = 0;
        LinkedList<Integer> list = Arrays.stream(cards).boxed().collect(Collectors.
                toCollection(LinkedList::new));

        while (!list.isEmpty()){
            if(list.size() == 1){
                answer = list.poll();
                break;
            }
            int max1= Collections.max(list);
            list.remove((Integer) max1);
            int max2 = Collections.max(list);
            list.remove((Integer) max2);
            list.add(max1 - max2);

        }

        return answer;
    }

    public static void main(String[] args) {
        int[] cards = {4,6,8,1,2};
        System.out.println(solution(cards));
    }
}
