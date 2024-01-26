package codingTest.CT.CT16.ct01;

import java.util.*;

//24-01-26(풀이) - 다시 풀기 = 자료구조 이해
public class Solution {

  public int[] solution(int[] nums, int k) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for (int i : nums) {
      hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
    }

    List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hashMap.entrySet());
    list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

    int size = Math.min(k, list.size());
    int[] answer = new int[size];
    for (int i = 0; i < size; i++) {
      answer[i] = list.get(i).getKey();
    }

    return answer;
  }

  public static void main(String[] args) {

  }
}
