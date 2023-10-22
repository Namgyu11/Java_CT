package codingTest.CT.CT02.ct02;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;


//23-10-22(풀이) - 다시 풀기 시간 초과
public class Solution {
    public static int[] solution(int[] a, int[] b) {

        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        for(int i : a){
            str1.append(i);
        }

        for(int i : b){
            str2.append(i);
        }

        BigInteger bigInt1 = new BigInteger(str1.toString());
        BigInteger bigInt2 = new BigInteger(str2.toString());

        BigInteger sum = bigInt1.add(bigInt2);


        String add = sum.toString();

        int[] answer = new int[add.length()];
        if(!add.equals("0")){
            for (int i = 0; i <add.length() ; i++) {
                answer[i] = Integer.parseInt(String.valueOf(add.charAt(i)));
            }
        }

        return answer;
    }
    public static int[] s1(int[] a, int[] b){
        int length = Math.max(a.length, b.length);
        int[] result = new int[length + 1];

        for (int i = 0; i < length; i++) {
            int numA = i < a.length ? a[a.length - 1 - i] : 0;
            int numB = i < b.length ? b[b.length - 1 - i] : 0;

            result[length - i] += numA + numB;
            if (result[length - i] >= 10) {
                result[length -i] -=10;
                result[length-i-1]++;
            }
        }

        // Remove leading zero if necessary
        if (result[0] == 0) {
            return Arrays.copyOfRange(result, 1, length + 1);
        } else {
            return result;
        }

    }
    private static BigInteger arrayToBigInteger(int[] arr) {
        String strNum = "";
        for (int i : arr) {
            strNum += Integer.toString(i);
        }

        return new BigInteger(strNum);
    }

    public static void main(String[] args) {

        int[] a = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        int[] b = {1};
        System.out.println(Arrays.toString(s1(a,b)));
    }
}
