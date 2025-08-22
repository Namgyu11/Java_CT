package inflearn.session03.ct01.퍼즐게임챌린지;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int n = diffs.length;
        int low = 1;
        int high = 0;
        for (int d : diffs) {
            high = Math.max(high, d);
        }
        int answer = high;
        while(low <= high){
            int mid = (low + high) / 2;
            long totalTime = getTotalTime(diffs, times, mid);
            if(totalTime <= limit){
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }
    
    private long getTotalTime(int[] diffs, int[] times, int level) {
        int n = diffs.length;
        long total = 0;
        total += times[0];
        for (int i = 1; i < n; i++) {
            int diff = diffs[i];
            int timeCur = times[i];
            int timePrev = times[i - 1];
            if(diff <= level) {
                total += timeCur;
            } else {
                int mistakes = diff - level;
                total += (long) mistakes * (timeCur + timePrev) + timeCur;
            }
            if (total > 1e15) {
                break;
            }
        }
        return total;
    }
}
