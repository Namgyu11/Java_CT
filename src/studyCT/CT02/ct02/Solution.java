package studyCT.CT02.ct02;

import java.util.Stack;

public class Solution {
  public int trap(int[] height) {
    Stack<Integer> stack = new Stack<>();

    int i = 0;
    int maxWater = 0;
    int maxBotWater = 0;

    while (i < height.length){
      // 현재 높이가 스택에 저장된 높이보다 낮으면, 스택에 인덱스를 push
      if(stack.isEmpty() || height[i] <= height[stack.peek()]){
        stack.push(i++);
      }else {
        // 현재 벽이 스택에 있는 벽보다 높은 경우. 물이 고일 수 있는 가능성 존재

        int bot = stack.pop(); // 바닥 벽을 pop

        //스택이 비어있지 않고, 물이 고일 수 있는 경우 계산
        if(!stack.isEmpty()){
          // 고일 수 있는 물의 최대 높이 계산
          maxBotWater = Math.min(height[stack.peek()], height[i]);

          //고일 수 있는 물의 양 계산 (너비 * 높이)
        }

      }
    }

    return 0;
  }


}
