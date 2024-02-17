package codingTest.CT.CT19.ct03;


import java.util.*;

public class Solution {

  public static int solution(int[] param0) {
    int answer = 0;
    Arrays.sort(param0);

    if(param0[0] > 1){
      answer += param0[0] - 1;
    }

    for (int i = 0; i < param0.length; i++) {

       if(i != 0 && param0[i] - param0[i-1] != 1){
        answer += param0[i] - param0[i-1] - 1;
      }
    }
    System.out.println(answer);
    return answer;
  }

  public static void main(String[] args) {
    solution(new int[]{1,2,3,4});
  }
}
