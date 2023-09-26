package codingTest.preCT_00.ct03.ct03_05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class solution {
    public static String solution(String[] bj, String[] one, String[] two) {
        String answer = "";
        int prize = 0;
        List<String> list = Arrays.stream(bj).collect(Collectors.toList());

        for(String s : one){
            list.remove(s);
            prize += 150;
        }
        for(String s : two){
            list.remove(s);
            prize +=300;
        }
        prize += 450;
        answer = prize+"만원" + "("+ list.get(0) +")";
        return answer;

    }

    public static void main(String[] args) {
        String[] bj = {"혁준", "하밥", "양상", "심심이", "소스왕"};
        String[] one = {"혁준", "양상"};
        String[] two = {"심심이", "소스왕"};
        List<String> list = Arrays.stream(bj).collect(Collectors.toList());
        System.out.println(solution(bj,one,two));
    }
}
