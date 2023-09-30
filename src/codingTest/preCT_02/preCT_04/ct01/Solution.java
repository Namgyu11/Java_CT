package codingTest.preCT_02.preCT_04.ct01;

public class Solution {
    public static int solution(int N, int K) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if(String.valueOf(i).contains(String.valueOf(K))){
                String[] temp = String.valueOf(i).split("");
                for (int j = 0; j < temp.length; j++) {
                    if(temp[j].equals(String.valueOf(K))){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 25;
        int k = 2;
        System.out.println(solution(n,k));
    }
}
