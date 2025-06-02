package codingTest.CT.preCT_00.ct07.ct07_04;

public class Solution {
    public static int solution(int A, int B) {
        int answer = 0;
        String a = Integer.toBinaryString(A);
        a = String.format("%08d",Integer.parseInt(a));
        String[] aStr = a.split("");

        String b = Integer.toBinaryString(B);
        b = String.format("%08d",Integer.parseInt(b));
        String[] bStr = b.split("");

        for (int i = 0; i < aStr.length; i++) {
            if(!aStr[i].equals(bStr[i])){
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int a = 29;
        int b = 15;
        System.out.println(solution(a,b));

    }
}
