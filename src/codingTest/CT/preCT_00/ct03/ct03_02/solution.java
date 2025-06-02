package codingTest.CT.preCT_00.ct03.ct03_02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class solution {
    public int solution(String S) {
        int answer = 0;
        List<String> list = Arrays.stream(S.split("")).collect(Collectors.toList());
        String[] str = S.split("");
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str.length; j++) {
                if(str[i] == "("){
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "({)}[<]>";
        String s1 = "(()){[<>]}";
        List<String> list = Arrays.stream(s.split("")).collect(Collectors.toList());
        System.out.println(list);

    }
}
