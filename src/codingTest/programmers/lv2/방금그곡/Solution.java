package codingTest.programmers.lv2.방금그곡;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String target = normalize(m);
        String answer = "(None)";
        int maxTime = -1;
        for (String info : musicinfos) {
            String[] parts = info.split(",");
            int start = toMinutes(parts[0]);
            int end   = toMinutes(parts[1]);
            int playTime = end - start;
            String title = parts[2];
            String melody = normalize(parts[3]);
            String played = buildPlayed(melody, playTime);
            if (played.contains(target)) {
                if (playTime > maxTime) {
                    maxTime = playTime;
                    answer = title;
                }
            }
        }
        return answer;
    }

    private int toMinutes(String time) {
        String[] hm = time.split(":");
        return Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
    }

    private String normalize(String s) {
        return s.replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("A#", "a");
    }

    private String buildPlayed(String melody, int length) {
        StringBuilder sb = new StringBuilder();
        int mlen = melody.length();
        for (int i = 0; i < length; i++) {
            sb.append(melody.charAt(i % mlen));
        }
        return sb.toString();
    }
}
