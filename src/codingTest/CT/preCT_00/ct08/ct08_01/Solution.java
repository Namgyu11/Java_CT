package codingTest.CT.preCT_00.ct08.ct08_01;

public class Solution {
    public static int solution(int N, int K) {
        int answer = 0;

        for (int i = 0; i <= N ; i++) {
            if(String.valueOf(i).contains(String.valueOf(K))){
                answer+= String.valueOf(i).length() - String.valueOf(i).replace(String.valueOf(K),"").length();
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int a = 25;
        int b = 2;
        String c =String.valueOf(a)+ a;

        String g = "a" + 1 + 3;
        System.out.println(g);
        System.out.println(solution(a,b));
    }
}
