package codingTest.CT.CT10.ct04;

public class Solution {
    public boolean solution(int[] param0) {
        int maxReach = 0;
        for (int i = 0; i < param0.length; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(param0[i] + i, maxReach);
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
