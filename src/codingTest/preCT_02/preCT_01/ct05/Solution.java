package codingTest.preCT_02.preCT_01.ct05;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

//23-09-26(풀이) - 다시 풀어보기
public class Solution {
    public int[] solution(int[] arr1, int[] arr2) {
        Set<Integer> set1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(arr2).boxed().collect(Collectors.toSet());

        set1.retainAll(set2);

       return set1.stream().mapToInt(Integer::intValue).toArray();
    }
    
}
