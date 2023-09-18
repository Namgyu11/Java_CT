package codingTest.pro.arrayTest.stringArr;

public class Solution {
    public static int solution(String s){

        String [] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i <arr.length ; i++) {
            if(s.contains(arr[i])){
                s = s.replace(arr[i],String.valueOf(i));
            }
        }
        return Integer.valueOf(s);
    }

    public static void main(String[] args) {

    }
}
