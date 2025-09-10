package inflearn.session02.ct07.호텔방배정;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Long, Long> parent = new HashMap<>();

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        for (int i = 0; i < room_number.length; i++) {
            long want = room_number[i];
            long avail = find(want);
            answer[i] = avail;
            parent.put(avail, find(avail + 1));
        }
        return answer;
    }

    private long find(long x) {
        if (!parent.containsKey(x)) {
            parent.put(x, x);
            return x;
        }
        long p = parent.get(x);
        if (p == x) {
            return x;
        }
        long root = find(p);
        parent.put(x, root);
        return root;
    }
}
