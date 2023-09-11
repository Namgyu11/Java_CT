package codingTest.pro.stackTest.sameNum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
같은 숫자는 싫어
*/
public class Solution {
    public  static int[] solution(int[] arr) {
        int[] answer;
        ArrayList<Integer> list = new ArrayList();

        Stack stack = new Stack<>();

        for (int i = arr.length -1 ; i >=0; i--) {
            stack.push(arr[i]);
        }

        while (true){
            int i = (int) stack.pop();
            if(stack.isEmpty()){
                list.add(i);
                break;
            }else if((i != (int) stack.peek())){
                list.add(i);
            }
        }
        answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};

       System.out.println(Arrays.toString(solution(arr)));
    }
}
