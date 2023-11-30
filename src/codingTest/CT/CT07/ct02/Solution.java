package codingTest.CT.CT07.ct02;

import java.util.*;
import java.util.Map.Entry;

//23-11-24(풀이)
public class Solution {
    public static int solution1(int[] votes) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < votes.length; i++) {
            map.put(votes[i], map.getOrDefault(votes[i], 0) + 1);
        }
        int maxVotes = Collections.max(map.values());
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == maxVotes){
                if(votes.length / 2 < maxVotes){
                    return entry.getKey();
                }
            }
        }
        return answer;
    }

    public static int solution(int[] votes) {
        int answer = 0;
        int maxVotes = 0;
        int maxNum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < votes.length; i++) {
            int cnt = map.getOrDefault(votes[i], 0) + 1;
            map.put(votes[i], cnt);

            if (cnt > maxVotes) {
                maxVotes = cnt;
                maxNum = votes[i];
            }
            if (maxVotes > votes.length / 2) {
                break;
            }
        }
        if (votes.length / 2 < maxVotes) {
            return maxNum;
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] v = {1, 4, 2, 2, 2, 3, 2, 2, 1};
        System.out.println(solution1(v));
    }
}
