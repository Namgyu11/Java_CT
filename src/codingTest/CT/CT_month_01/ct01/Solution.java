package codingTest.CT.CT_month_01.ct01;
import java.util.*;


//22-10-13(풀이) - 다시 풀기!!
// 그래프 탐색 알고리즘 - 너비 우선 탐색 BFS
public class Solution {


    public static int solution(int N, int[][] house) {
        int answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] house = {{0, 0, 0, 0, 0, 0}, {0, 4, 0, 0, 0, 0}, {0, 0, 0, 2, 0, 0},
        {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 3, 0, 0, 0, 0}};
        System.out.println(solution(n,house));
    }


}
