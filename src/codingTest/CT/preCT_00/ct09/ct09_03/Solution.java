package codingTest.CT.preCT_00.ct09.ct09_03;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static int solution(int[] cards) {
        if(cards.length == 0) return 0;
        int answer = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int card : cards) {
            arrayList.add(card);
        }
        if(arrayList.size() == 1) return arrayList.get(0); // 하나의 요소만 있는 경우

        while (!arrayList.isEmpty()) {
            int max = Collections.max(arrayList);
            int maxIndex = arrayList.indexOf(max);
            arrayList.remove(maxIndex);

            if(arrayList.isEmpty()){
                break;
            }
            int max2 = Collections.max(arrayList);
            int maxIndex2 = arrayList.indexOf(max2);
            arrayList.remove(maxIndex2);

            if (max != max2) {
                arrayList.add(max - max2);
            }
            if (arrayList.size() == 1) {
                answer = arrayList.get(0);
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] card = {4, 6, 8, 1, 2};

        System.out.println(solution(card));
    }
}
