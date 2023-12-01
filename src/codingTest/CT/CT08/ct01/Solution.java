package codingTest.CT.CT08.ct01;
import java.util.*;

// 23-12-01 (풀이) - 다시 풀어 보기 (dp)

public class Solution {
    class Job implements Comparable<Job> {
        int start, end, price;

        Job(int start, int end, int price) {
            this.start = start;
            this.end = end;
            this.price = price;
        }

        @Override
        public int compareTo(Job o) {
            return this.end - o.end;
        }
    }

    public int solution(int[] start, int[] end, int[] price) {
        int n = start.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(start[i], end[i], price[i]);
        }
        Arrays.sort(jobs);

        int[] dp = new int[n];
        dp[0] = jobs[0].price;

        for (int i = 1; i < n; i++) {
            int profit = jobs[i].price;
            int l = search(jobs, i);
            if (l != -1) profit += dp[l];
            dp[i] = Math.max(profit, dp[i-1]);
        }
        return dp[n-1];
    }

    int search(Job jobs[], int index) {
        int start = 0, end = index - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (jobs[mid].end <= jobs[index].start) {
                if (jobs[mid + 1].end <= jobs[index].start) start = mid + 1;
                else return mid;
            }
            else end = mid - 1;
        }
        return -1;
    }
}
