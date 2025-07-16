package codingTest.preCT_02.preCT_03_01.ct01.ct04.ct05.표현가능한이진트리.연속펄스부분수열의합.preCT_03_02.ct04;

public class Solution {
    public boolean solution(boolean[][] matrix, boolean b) {
        boolean answer = true;
        for (int i = 0; i <matrix.length; i++) {
            for (int j = 0; j <matrix.length; j++) {
               if( matrix[i][j] != b){
                   return false;
               }
            }
        }
        return answer;
    }
}
