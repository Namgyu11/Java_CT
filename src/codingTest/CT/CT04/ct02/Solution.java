package codingTest.CT.CT04.ct02;

import java.util.Arrays;

public class Solution {
    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (queries[i].charAt(0) != '*') {
                    if (words[j].startsWith(queries[i].substring(0, queries[i].length() - 1))) {
                        answer[i]++;
                    }
                } else {
                    if (words[j].endsWith(queries[i].substring(1))) {
                        answer[i]++;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] words = {"zero", "base", "students", "are", "the", "best"};
        String[] queries = {"z*", "*e", "s*"};
        System.out.println(Arrays.toString(solution(words, queries)));
    }
}
