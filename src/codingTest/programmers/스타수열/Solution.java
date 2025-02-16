package codingTest.programmers.스타수열;

class Solution {
    public int solution(int[] a) {
        int n = a.length;
        int answer = 0;
        
        int[] freq = new int[n];
        for (int num : a) {
            freq[num]++;
        }
        
        for (int candidate = 0; candidate < n; candidate++) {
            if (freq[candidate] * 2 <= answer) {
                continue;
            }
            
            int pairs = 0;
            for (int i = 0; i < n - 1; i++) {
                if ((a[i] == candidate || a[i+1] == candidate) && a[i] != a[i+1]) {
                    pairs++;
                    i++;
                }
            }
            answer = Math.max(answer, pairs * 2);
        }
        
        return answer;
    }
}
