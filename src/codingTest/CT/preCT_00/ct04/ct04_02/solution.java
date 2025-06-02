package codingTest.CT.preCT_00.ct04.ct04_02;

public class solution {
    public static boolean solution(int n) {
        boolean answer;

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if(n % i ==0){
                count++;
            }
        }
        if(count ==2){
            answer =true;
        }
        else {
            answer =false;
        }
        return answer;
    }

    public static void main(String[] args) {

        int a = 7;

        System.out.println(solution(a));

    }
}
