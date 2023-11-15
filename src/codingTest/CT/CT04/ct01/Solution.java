package codingTest.CT.CT04.ct01;

import java.util.*;

public class Solution {
    public String[][] solution(String[] titles, String[] lyrics, String[] problems) {
        ArrayList<ArrayList<String>> answer = new ArrayList<>();
        for (int i = 0; i < problems.length; i++) {
            answer.add(new ArrayList<>());
            for (int j = 0; j < lyrics.length; j++) {
                if (lyrics[j].substring(0, Math.min(problems[i].length(), lyrics[j].length())).equals(problems[i])) {
                    answer.get(i).add(titles[j]);
                }
            }
        }
        return answer.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);

    }

    public static String[][] solution2(String[] titles, String[] lyrics, String[] problems) {
        String[][] answer = new String[problems.length][];
        for (int i = 0; i < lyrics.length; i++) {
            for (int j = 0; j < problems.length; j++) {
                if (lyrics[i].substring(0, problems[j].length()).equals(problems[j])) {
                    answer[j][answer[j].length] = titles[i];
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
