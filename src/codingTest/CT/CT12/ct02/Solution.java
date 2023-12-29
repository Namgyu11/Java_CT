package codingTest.CT.CT12.ct02;


//23-12-28(풀이) - 다시 풀기
import java.util.Stack;

public class Solution {
    public int solution(int[] heights) {
        // 스택을 생성합니다. 이 스택에는 각 막대의 인덱스가 저장.
        Stack<Integer> stack = new Stack<>();

        // 가장 큰 직사각형의 넓이를 저장할 변수를 선언.
        int maxArea = 0;

        // 각 막대를 순회합니다.
        for (int i = 0; i <= heights.length; i++) {
            // 현재 막대의 높이가 스택의 최상위 막대의 높이보다 낮거나, 모든 막대를 순회한 경우
            while (!stack.isEmpty() && (i == heights.length
                    || heights[stack.peek()] > heights[i])) {

                // 스택의 최상위 막대를 꺼내어 그 높이를 저장.
                int height = heights[stack.pop()];
                // 스택의 최상위 막대를 기준으로 만들 수 있는 가장 넓은 직사각형의 너비를 계산.
                int width = (stack.isEmpty() ? i : i - stack.peek() - 1);
                // 이 직사각형의 넓이를 계산하고,
                // 이를 현재까지 찾은 가장 큰 직사각형의 넓이와 비교하여 더 큰 값을 저장.
                maxArea = Math.max(maxArea, width * height);
            }
            // 현재 막대의 인덱스를 스택에 쌓는다.
            stack.push(i);
        }

        // 가장 큰 직사각형의 넓이를 반환.
        return maxArea;
    }
}
