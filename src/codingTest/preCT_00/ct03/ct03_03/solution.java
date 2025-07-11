package codingTest.preCT_00.ct03.ct03_03;

public class solution {
    public static int solution(String S) {
        int count = 1;
        String answer = S;
        for (int i = 0; i < S.length(); i++) {
            if(S.indexOf(S.charAt(i)) != i){
                String temp = String.valueOf(S.charAt(i));
                answer = answer.replace(temp+temp, "");
            }
        }
        if (!answer.isEmpty()){
            count = 0;
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "ABBA";
        System.out.println(solution(s));
    }
}
