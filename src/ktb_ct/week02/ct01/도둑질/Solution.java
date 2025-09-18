package ktb_ct.week02.ct01.도둑질;

class Solution {
    public int solution(int[] money) {
        int n = money.length;
        return Math.max(rob(money, 0, n - 2), rob(money, 1, n - 1));
    }
    private int rob(int[] a, int l, int r) {
        int prev = 0, curr = 0;
        for (int i = l; i <= r; i++) {
            int next = Math.max(curr, prev + a[i]);
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
