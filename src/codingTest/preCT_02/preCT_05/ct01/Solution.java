package codingTest.preCT_02.preCT_05.ct01;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

//23-10-01(풀이) 다시 풀어보기
public class Solution {
    public int solution(String sentence, String word) {
        int answer;
        String[] str = sentence.toLowerCase().split(" ");
        LinkedList<String> list = Arrays.stream(str).collect(Collectors.toCollection(LinkedList::new));

        answer = list.indexOf(word);
        return answer;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int s = list.indexOf(4);
        System.out.println(s);

    }
}
