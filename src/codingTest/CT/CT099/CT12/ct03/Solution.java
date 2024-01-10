package codingTest.CT.CT099.CT12.ct03;

//23-12-28(풀이) - 다시 풀기
public class Solution {
    public int solution(int[] status) {
        int count = 0;
        for (int i = 0; i < status.length - 2; i++) {
            if (status[i] == 0) {
                count++;
                status[i] = 1;
                status[i + 1] = status[i + 1] == 0 ? 1 : 0;
                status[i + 2] = status[i + 2] == 0 ? 1 : 0;
            }
        }
        if (status[status.length - 2] != status[status.length - 1]) {
            return -1;
        }
        if (status[status.length - 2] == 0) {
            count++;
        }
        return count;
    }
}
