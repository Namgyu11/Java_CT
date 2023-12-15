package codingTest.CT.CT10.ct02;

//23-12-14(풇이) - 다시 풀기 - 그리디
public class Solution {
    public static int solution(int num) {
        // 숫자를 문자열로 변환
        char[] numArray = Integer.toString(num).toCharArray();
        // 가장 큰 숫자와 그 위치를 찾는다.
        for (int i = 0; i < numArray.length; i++) {
            int swapIndex = -1;
            char maxNum = '0';
            for (int j = i + 1; j < numArray.length; j++) {
                if (numArray[j] >= maxNum) {
                    maxNum = numArray[j];
                    swapIndex = j;
                }
            }
            // 만약 현재 위치의 수보다 큰 수 중 가장 작은 수를 찾았다면 교환한다.
            if (swapIndex != -1 && numArray[i] < numArray[swapIndex]) {
                char temp = numArray[i];
                numArray[i] = numArray[swapIndex];
                numArray[swapIndex] = temp;
                break;
            }
        }
        // 결과를 반환한다.
        return Integer.parseInt(new String(numArray));
    }

}
