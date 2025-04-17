package codingTest.preCT_02.preCT_04.ct03.ct04.ct03;

//23-09-30 (풀이) - 다시 풀기
public class Solution {
    public static int solution(String S1, String S2) {
        String doubledS1 = S1 + S1;
        return doubledS1.contains(S2) ? 1 : 0;
    }

    public static void main(String[] args) {
        String s1 = "helloworld";
        String s2 = "worldhello";


        System.out.println(solution(s1,s2));
    }
}
