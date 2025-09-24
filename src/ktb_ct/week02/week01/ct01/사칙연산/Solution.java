package ktb_ct.week02.week01.ct01.사칙연산;

class Solution {
    public long solution(String[] arr) {
        int n = (arr.length + 1) / 2;  
        long[] nums = new long[n];
        char[] ops = new char[n - 1];
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(arr[2 * i]);
            if (i < n - 1) {
                ops[i] = arr[2 * i + 1].charAt(0);
            }
        }
        long[][] dpMax = new long[n][n];
        long[][] dpMin = new long[n][n];
        for (int i = 0; i < n; i++) {
            dpMax[i][i] = nums[i];
            dpMin[i][i] = nums[i];
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                long maxVal = Long.MIN_VALUE;
                long minVal = Long.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    char op = ops[k];
                    long a = dpMax[i][k];
                    long b = dpMin[i][k];
                    long c = dpMax[k+1][j];
                    long d = dpMin[k+1][j];
                    long curMax, curMin;
                    if (op == '+') {
                        curMax = a + c;
                        curMin = b + d;
                    } else { 
                        curMax = a - d;
                        curMin = b - c;
                    }
                    if (curMax > maxVal) {
                        maxVal = curMax;
                    }
                    if (curMin < minVal) {
                        minVal = curMin;
                    }
                }
                dpMax[i][j] = maxVal;
                dpMin[i][j] = minVal;
            }
        }
        return dpMax[0][n-1];
    }
}
