package codingTest.preCT_02.preCT_03_01.ct05.표현가능한이진트리.연속펄스부분수열의합.preCT_03_02.ct02;

import java.util.ArrayList;
import java.util.Arrays;

//23-10-07(풀이) - 다시 풀기
public class Solution {
    public int[] solution(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        ArrayList<Integer> list = new ArrayList();
        int i =0;
        int j =0;
        while ( i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]){
                i++;
            }else if(arr1[i] > arr2[j]){
                j++;
            }else {
                list.add(arr1[i]);
                i++;
                j++;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
