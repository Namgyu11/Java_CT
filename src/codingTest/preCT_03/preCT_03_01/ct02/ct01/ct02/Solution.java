package codingTest.preCT_03.preCT_03_01.ct02.ct01.ct02;

import java.util.Arrays;
import java.util.Collections;

//23-10-06(풀이) 다시 풀어보기
public class Solution {
    public static int solution(int[] arr) {

        Integer[] scores = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(scores, Collections.reverseOrder());
        arr = Arrays.stream(scores).mapToInt(Integer::intValue).toArray();
        int cnt = 0;
        for (int i = 0; i <arr.length; i++) {
            if(cnt > arr.length / 2){
                if(arr[i]== arr[i-1]){
                    cnt++;
                }else {
                    break;
                }
            }else {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {95,90,95,100,95};
        int[] arr1 = {100,99,98,90,90,90};
        int a = 5/2;
        System.out.println(solution(arr1));
    }
}
