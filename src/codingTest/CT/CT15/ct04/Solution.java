package codingTest.CT.CT15.ct04;
import java.util.Arrays;

//24-01-19(풀이) - 다시 풀기 - 그리디
public class Solution {
    public int solution(int[] numsDivide, int[] numsDivided) {
        Arrays.sort(numsDivide);
        int removed = 0;

        for (int i = 0; i < numsDivide.length; i++) {
            boolean canDivideAll = true;
            for (int j = 0; j < numsDivided.length; j++) {
                if (numsDivided[j] % numsDivide[i] != 0) {
                    canDivideAll = false;
                    break;
                }
            }
            if (canDivideAll) {
                return removed;
            }
            removed++;
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
