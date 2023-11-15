package codingTest.CT.CT04.ct03;

import java.util.*;

public class Solution {

    public String[][] solution(String[] words, String[] queries) {
        ArrayList<ArrayList<String>> answer = new ArrayList<>();
        answer.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);

        for (int i = 0; i <queries.length; i++) {
            answer.add(new ArrayList<>());
            for (int j = 0; j <words.length; j++) {
                if(words[j].length() == queries[i].length()){
                    int idx = queries[i].indexOf('?');
                    String str = queries[i].substring(0,idx);
                    if(words[j].substring(0,Math.min(str.length(),words[j].length())).equals(str)){
                        answer.get(i).add(words[j]);
                    }
                }
            }
        }
        return answer.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
    }


}
