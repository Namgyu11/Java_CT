package codingTest.preCT_00.ct09.ct09_01;

public class Solution {
    public static int solution(String sentence, String word) {
        int answer = -1;
        String[] str = sentence.split(" ");
        for (int i = 0; i <str.length; i++) {
            if(str[i].equals(word)){
                answer = i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        String a = "Hello every world";
        String b = "Hello";
        System.out.println(solution(a,b));

    }
}
