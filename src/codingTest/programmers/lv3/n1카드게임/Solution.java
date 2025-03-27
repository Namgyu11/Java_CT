package codingTest.programmers.lv3.n1카드게임;

import java.util.*;
class Solution {
    int n, initCount;
    int[] deck;
    HashMap<String, Integer> memo = new HashMap<>();

    public int solution(int coin, int[] cards) {
        n = cards.length;
        deck = cards;
        initCount = n / 3;
        List<Integer> hand = new ArrayList<>();

        for (int i = 0; i < initCount; i++) {
            hand.add(cards[i]);
        }
        Collections.sort(hand);
        return dfs(0, coin, hand);
    }

    int dfs(int round, int coin, List<Integer> hand) {
        int idx = initCount + 2 * round;
        String key = round + "#" + coin + "#" + handToString(hand);
        if(memo.containsKey(key)) return memo.get(key);

        if(idx >= n) {
            memo.put(key, round + 1);
            return round + 1;
        }

        int best = round;
        int card1 = deck[idx], card2 = deck[idx + 1];

        for (int choice1 = 0; choice1 < 2; choice1++) {
            int cost1 = (choice1 == 1 ? 1 : 0);
            if(cost1 > coin) continue;
            List<Integer> handAfter1 = new ArrayList<>(hand);
            if(choice1 == 1) {
                handAfter1.add(card1);
                Collections.sort(handAfter1);
            }
            for (int choice2 = 0; choice2 < 2; choice2++) {
                int cost2 = (choice2 == 1 ? 1 : 0);
                if(cost1 + cost2 > coin) continue;
                List<Integer> handAfter2 = new ArrayList<>(handAfter1);
                if(choice2 == 1) {
                    handAfter2.add(card2);
                    Collections.sort(handAfter2);
                }

                int remainingCoin = coin - cost1 - cost2;
                List<int[]> removablePairs = getRemovablePairs(handAfter2);

                if(removablePairs.isEmpty()){
                    best = Math.max(best, round + 1);
                } else {
                    for (int[] pair : removablePairs) {
                        List<Integer> handAfterRemoval = new ArrayList<>(handAfter2);
                        handAfterRemoval.remove((Integer) pair[0]);
                        handAfterRemoval.remove((Integer) pair[1]);
                        int res = dfs(round + 1, remainingCoin, handAfterRemoval);
                        best = Math.max(best, res);
                    }
                }
            }
        }
        memo.put(key, best);
        return best;
    }

    List<int[]> getRemovablePairs(List<Integer> hand) {
        List<int[]> pairs = new ArrayList<>();
        Set<Integer> set = new HashSet<>(hand);
        for (int x : hand) {
            int y = n + 1 - x;
            if (x < y && set.contains(y)) pairs.add(new int[]{x, y});
        }
        return pairs;
    }

    String handToString(List<Integer> hand) {
        StringBuilder sb = new StringBuilder();
        for (int x : hand) sb.append(x).append(",");
        return sb.toString();
    }
}
