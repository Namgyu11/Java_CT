package studyCT.CT02.ct01;

import java.util.Arrays;
import java.util.Stack;

/*
* 739. Daily Temperatures
*
* */
public class Solution {
  public static int[] dailyTemperatures(int[] temperatures) {

    int n = temperatures.length;
    int[] answer = new int[n];
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < n; i++) {
      // 현재 온도가 스택의 맨 위에 있는 날짜의 온도보다 높은 경우
      while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
        System.out.println(stack.peek());
        int prevIndex = stack.pop(); // 이전에 더 낮은 온도를 가진 날짜의 인덱스
        answer[prevIndex] = i - prevIndex; // 더 따뜻한 날까지 기다려야 하는 날짜 수 계산
      }
      stack.push(i); // 현재 날짜의 인덱스를 스택에 삽입
    }

    // 스택에 남아있는 인덱스에 대해 더 따뜻한 날이 없으므로 0으로 남김
    return answer;

  }

  public static void main(String[] args) {

    System.out.println(
        Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}))) ;
  }

}
