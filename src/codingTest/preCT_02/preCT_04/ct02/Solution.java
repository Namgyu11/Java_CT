package codingTest.preCT_02.preCT_04.ct02;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.stream.Collectors;
import java.util.*;
import java.util.stream.*;

//23-09-30(풀이) - 다시 풀어보기

public class Solution {
    public static int solution(int[] A, int K) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                list.add(A[i] * 10 + A[j]);
                list.add(A[j] * 10 + A[i]);
            }
        }
        Collections.sort(list,Collections.reverseOrder());

        return list.get(K -1);
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int k = 1;
        System.out.println(solution(a,k));
    }
}
