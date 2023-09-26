package codingTest.preCT_00.ct06.ct06_05;

public class Solution {
    public static int solution(int num) {
        int answer = 0;
        String temp = "";
        String str = String.valueOf(num);


        if(str.charAt(0) != '-'){
            for (int i = str.length() -1 ; i >=0 ; i--) {
                temp += str.charAt(i);
            }
        }else{
            for (int i = str.length() -1 ; i >=1 ; i--) {
                temp += str.charAt(i);
            }
            temp = "-" + temp;
        }
        answer = Integer.parseInt(temp);
        if(answer <= -100000 || answer >= 100000){
            answer = 0;
        }

        return answer;
    }

    public static void main(String[] args) {

        int a = -5;
        int b = -100000;
        String n = String.valueOf(b);
        System.out.println(solution(b));
    }
}
