package codingTest.programmers.lv3.추석트래픽;

class Solution {
    public int solution(String[] lines) {
        int n = lines.length;
        long[] start = new long[n];
        long[] end = new long[n];
        for (int i = 0; i < n; i++) {
            String[] parts = lines[i].split(" ");
            String time = parts[1];
            String proc = parts[2];
            String[] t = time.split(":");

            int hh = Integer.parseInt(t[0]);
            int mm = Integer.parseInt(t[1]);

            String[] sec = t[2].split("\\.");
            int ss = Integer.parseInt(sec[0]);
            int ms = Integer.parseInt(sec[1]);
            long endMs = ((hh * 3600L + mm * 60L + ss) * 1000L) + ms;
            double pd = Double.parseDouble(proc.substring(0, proc.length() - 1));
            long durMs = (long)(pd * 1000);
            long startMs = endMs - durMs + 1;

            start[i] = startMs;
            end[i] = endMs;
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            long windowStart = end[i];
            long windowEnd = windowStart + 999;
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (end[j] < windowStart || start[j] > windowEnd) {
                    continue;
                }
                count++;
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }
}
