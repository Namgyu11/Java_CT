package ktb_ct.week02.ct01.동영상_재생기;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int V = toSec(video_len);
        int cur = toSec(pos);
        int L = toSec(op_start);
        int R = toSec(op_end);

        if (L <= cur && cur <= R) {
            cur = R;
        }

        for (String cmd : commands) {
            if (L <= cur && cur <= R) {
                cur = R;
            }

            if ("prev".equals(cmd)) {
                cur = Math.max(0, cur - 10);
            } else { 
                cur = Math.min(V, cur + 10);
            }

            if (L <= cur && cur <= R) {
                cur = R;
            }
        }

        return toMMSS(cur);
    }

    private int toSec(String s) {
        int mm = Integer.parseInt(s.substring(0, 2));
        int ss = Integer.parseInt(s.substring(3, 5));
        return mm * 60 + ss;
    }

    private String toMMSS(int sec) {
        int mm = sec / 60;
        int ss = sec % 60;
        return String.format("%02d:%02d", mm, ss);
    }
}
