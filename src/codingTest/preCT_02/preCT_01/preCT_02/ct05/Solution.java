package codingTest.preCT_02.preCT_01.preCT_02.ct05;

public class Solution {
    public static int solution(int num) {
        int answer;
        String s = String.valueOf(num);
        String reversed = new StringBuilder(s).reverse().toString();

        if (num < 0) {
            reversed = "-" + reversed.substring(0, reversed.length() - 1);
        }
        answer = Integer.parseInt(reversed);
        if (answer >= -100000 && answer <= 100000) {
            return answer;
        } else {
            return 0;
        }
    }


    public static void main(String[] args) {
        int num = -587;
        System.out.println(solution(num));
    }
}
