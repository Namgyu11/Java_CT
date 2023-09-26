package codingTest.preCT_00.ct05.ct05_02;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static int solution(int[] arr) {
        int answer = 0;

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Integer i : arr){
            arrayList.add(i);
        }
        int max = Collections.max(arrayList);
        int min = Collections.min(arrayList);
//        for (int i = 0; i < arr.length; i++) {
//            if(arr[i] == max){
//                arrayList.remove(i);
//                break;
//            }
//
//        }
//        for (int i = 0; i < arr.length; i++) {
//            if(arr[i] == min){
//                arrayList.remove(i);
//                break;
//            }
//        }
        arrayList.removeIf(x -> x.equals(max) || x.equals(min));

        int sum = arrayList.stream().mapToInt(Integer::intValue).sum();
        answer = sum/arrayList.size();
        return answer;
    }

    public static void main(String[] args) {

        int[] arr = {2,3,3,3,20};
        System.out.println(solution(arr));
    }
}
