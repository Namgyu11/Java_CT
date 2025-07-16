package codingTest.preCT_02.preCT_03_01.ct02.ct03.preCT_03_02.preCT_03_03.ct02;


import java.util.Arrays;

//23-10-07(풀이)-- 다시 풀기
public class Solution {
    public static int solution(int[] people, int limit) {
        Arrays.sort(people);

        int i = 0;
        int j = people.length -1;
        int answer = 0;

        while (i<=j){
            if(people[i] + people[j] <= limit){
               i++;
            }
            j--;
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] a = {45,50,51,49,90,70};
        int b = 100;
        System.out.println(solution(a,b));
    }
}
