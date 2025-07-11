package codingTest.preCT_03.preCT_03_01.ct01.ct04;

//23-10-06(풀이) - 다시 풀기
public class Solution {
    public static String solution(String s) {
        int count = 0;
        boolean inOneGroup = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (!inOneGroup && count > 0 && count < 3) return "NO";
                inOneGroup = true;
                count++;
            } else {
                if (inOneGroup && count > 3) return "NO";
                inOneGroup = false;
                count = 0;
            }
        }

        return "YES";
    }

    public static void main(String[] args) {
        String s = "111000010100";
        String a = "001001000100";
        System.out.println(solution(a));
    }
}
