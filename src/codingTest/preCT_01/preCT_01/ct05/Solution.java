package codingTest.preCT_01.preCT_01.ct05;

public class Solution {
    public static int solution(String S) {
        int count = 0;
        int binaryToDecimal = Integer.parseInt(S,2);

        while (true) {
            if(binaryToDecimal == 0){
                break;
            }else if (binaryToDecimal % 2 == 0) {
                binaryToDecimal /= 2;
            } else {
                binaryToDecimal -= 1;
            }
            count += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "1101";
        int x = Integer.parseInt(s,2);
        System.out.println(x);

    }
}

