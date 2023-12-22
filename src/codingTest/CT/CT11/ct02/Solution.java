package codingTest.CT.CT11.ct02;

import java.util.Arrays;
import java.util.Comparator;
//23-12-22(풀이) - 다시 풀기 - 커스텀 소팅
public class Solution {
    public Integer[] solution(int n) {
        Integer[] answer = new Integer[n];
        for (int i = 0; i < n; i++) {
            answer[i] = i + 1;
        }
        Arrays.sort(answer, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
        return answer;
    }
}
