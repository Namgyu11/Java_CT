package codingTest.CT.CT15.ct02;
import java.util.Arrays;


//24-01-19(풀이) - 다시 풀기 - 이분 탐색(Binary Search)과 정렬(Sorting)
public class Solution {
    public int solution(int[] buckets, int m) {
        Arrays.sort(buckets);
        int low = 0;
        int high = buckets[buckets.length - 1] - buckets[0];
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(buckets, mid, m)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    private boolean isPossible(int[] buckets, int distance, int m) {
        int count = 1;
        int prev = buckets[0];
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i] - prev >= distance) {
                count++;
                prev = buckets[i];
            }
        }
        return count >= m;
    }
}
