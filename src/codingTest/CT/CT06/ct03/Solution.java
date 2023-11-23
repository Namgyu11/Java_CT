package codingTest.CT.CT06.ct03;

import java.util.*;
import java.util.stream.Collectors;
//23-11-17(풀이) - 다시 풀기
public class Solution {


    public static int solution1(String[] ingredients, String[] items) {
        List<Integer> idx = new ArrayList<>();
        List<String> list = Arrays.stream(ingredients).collect(Collectors.toList());
        for (int i = 0; i < items.length; i++) {
            if(list.size() == 0){
                break;
            }
            if(list.remove(items[i])){
                idx.add(i);
            }
        }

        return Collections.max(idx) - Collections.min(idx) + 1;
    }
    public int solution(String[] ingredients, String[] items) {
        Map<String, Integer> map = new HashMap<>();
        int start = 0, len = Integer.MAX_VALUE;

        for (int end = 0; end < items.length; end++) {
            if (Arrays.asList(ingredients).contains(items[end])) {
                map.put(items[end], map.getOrDefault(items[end], 0) + 1);
            }

            while (included(ingredients, map)) {
                len = Math.min(len, end - start + 1);
                if (Arrays.asList(ingredients).contains(items[start])) {
                    if (map.get(items[start]) == 1) {
                        map.remove(items[start]);
                    } else {
                        map.put(items[start], map.get(items[start]) - 1);
                    }
                }
                start++;
            }
        }
        return len;
    }

    private boolean included(String[] ingredients, Map<String, Integer> map) {
        for (String ingredient : ingredients) {
            if (!map.containsKey(ingredient) || map.get(ingredient) < 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] ingredients = {"생닭", "인삼", "소주", "대추"};
        String[] items = {"물", "인삼", "커피", "생닭", "소주", "사탕", "생닭", "대추", "쌀"};
        System.out.println(solution1(ingredients,items));
    }
   // last idx - fir idx + 1
}
