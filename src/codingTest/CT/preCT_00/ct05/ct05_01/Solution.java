package codingTest.CT.preCT_00.ct05.ct05_01;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static int solution(int[] arr) {
        int answer = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (Integer i : arr) {
            arrayList.add(i);
        }
        while (!arrayList.isEmpty()) {
            int max = Collections.max(arrayList);
            int temp = 0;
            int temp1 = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == max) {
                    arrayList.set(i, 0);
                    temp = Collections.max(arrayList);
                }
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == temp) {
                    arrayList.set(i, 0);
                    temp1 = Collections.max(arrayList);
                    if (max < temp + temp1) {
                        answer = max + temp + temp1;
                        break;
                    } else {
                        arrayList.set(i, temp);
                    }
                }
            }
            if (max == 0 || answer != 0) {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 12, 8, 5, 9};
        System.out.println(solution(arr));
    }
}
