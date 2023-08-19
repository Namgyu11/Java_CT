package codingTest.preCT.ct03.ct03_04;

import java.util.Arrays;

public class solution {

    public static int solution(String s) {
        int answer;
        String[] str = s.split("(?=[-+])");
        answer = Arrays.stream(str).mapToInt(Integer::parseInt).sum();

        return answer;
    }

    public static void main(String[] args) {
        String s = "-3+26-7";
        //System.out.println(Arrays.toString(s.split("(?=[-+])")));
        System.out.println(solution(s));
    }
}
