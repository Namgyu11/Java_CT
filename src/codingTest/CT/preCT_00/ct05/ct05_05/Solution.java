package codingTest.CT.preCT_00.ct05.ct05_05;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static int[] solution(int[] arr1, int[] arr2) {
        ArrayList arrayList1 = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList<>();
        ArrayList temp = new ArrayList<>();
        for(int i : arr1){
            arrayList1.add(i);
        }
        for(int i : arr2){
            arrayList2.add(i);
        }
        if(arr1.length > arr2.length){
            for (int i = 0; i < arr1.length; i++) {
                if(arrayList2.contains(arr1[i])){
                    temp.add(arr1[i]);
                }
            }
        }else {
            for (int i = 0; i < arr2.length; i++) {
                if(arrayList1.contains(arr2[i])){
                    temp.add(arr2[i]);
                }
            }
        }
        int [] answer = new int[temp.size()];
        for (int i = 0; i <temp.size() ; i++) {
            answer[i] = (int)temp.get(i);
        }
        Arrays.sort(answer);
        return  answer;
    }

    public static void main(String[] args) {

        int[] arr1 = {1,7,8,4};
        int[] arr2 = {2,4,6,8};
        System.out.println(Arrays.toString(solution(arr1,arr2)));
    }
}
