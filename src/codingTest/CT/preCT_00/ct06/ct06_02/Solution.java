package codingTest.CT.preCT_00.ct06.ct06_02;

import java.util.ArrayList;

public class Solution {
    public static int[] solution(int[] arr) {
        int[] answer = {};
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arrayList.size() == arr.length){
                break;
            }
            if(arr[i] % 2 != 0){
                if(arrayList.size() == arr.length){
                    break;
                }
                arrayList.add(arr[i]);
                if(arrayList.size() == arr.length){
                    break;
                }
                arrayList.add(arr[i]);
            }else {
                if(arrayList.size() == arr.length){
                    break;
                }
                arrayList.add(arr[i]);
            }
        }
        answer = arrayList.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    public static void main(String[] args) {
        int[] a = {0,2,1,4,3,0};
        System.out.println(solution(a));
    }
}
