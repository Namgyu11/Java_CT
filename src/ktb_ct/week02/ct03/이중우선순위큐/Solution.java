package ktb_ct.week02.ct03.이중우선순위큐;

import java.util.TreeMap;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (String op : operations) {
            String[] parts = op.split(" ");
            String cmd = parts[0];
            int num = Integer.parseInt(parts[1]);
            if (cmd.equals("I")) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else if (cmd.equals("D")) {
                if (map.isEmpty()) {
                    continue;
                }
                int key = (num == 1) ? map.lastKey() : map.firstKey();
                int cnt = map.get(key);
                if (cnt == 1) {
                    map.remove(key);
                } else {
                    map.put(key, cnt - 1);
                }
            }
        }
        if (map.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{map.lastKey(), map.firstKey()};
        }
    }
}
