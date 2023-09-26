package codingTest.pro.arrayTest.rotatingArr;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

// 프로그래머스 - 코딩테스트 입문 - 배열 회전시키기
public class Solution {
    public static int[] solution(int[] numbers, String direction) {
        LinkedList<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toCollection(LinkedList::new));

        if(direction.equals("right")){
            list.offerFirst(list.pollLast());
        }else {
            list.offerLast(list.pollFirst());
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
        /*
        int[] answer = new int[numbers.length];
        int temp1 = numbers[numbers.length - 1];
        int temp2 = numbers[0];

        for (int i = 0; i < numbers.length; i++) {
            if (direction.equals("right")) {
                if (i == numbers.length - 1) {
                    answer[0] = temp1;
                } else {
                    answer[i + 1] = numbers[i];
                }
            } else {
                if (i == 0) {
                } else {
                    answer[i - 1] = numbers[i];
                    if (i == numbers.length - 1) {
                        answer[i] = temp2;
                    }
                }
            }
        }
        return answer;

         */
    }

    public static void main(String[] args) {

        int[] num = {1,2,3};
        String d = "right";
        System.out.println(Arrays.toString(solution(num, d)));
    }
}
