package codingTest.pro.linkedListTest.process;


import java.util.LinkedList;


/*코딩테스트 연습- 스택/큐 - 프로세스 */
public class Solution {
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            list.add(new int[]{priorities[i], i});
        }

        while (!list.isEmpty()) {
            int[] cur = list.poll();

            boolean hasHigherPriority = list.stream().anyMatch(d -> d[0] > cur[0]);

            if (hasHigherPriority) {
                list.addLast(cur);
            } else {
                answer++;
                if (cur[1] == location) {
                    return answer;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};

        int location = 2;
        System.out.println(solution(priorities, location));
    }
}
