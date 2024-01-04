package codingTest.CT.CT13.ct01;

//24-01-04(풀이) - 다시 풀기
public class Solution {
    public int solution(String s) {
        int i = 0, n = s.length();
        while (i < n && Character.isWhitespace(s.charAt(i))) {
            i++;
        }
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }
        while (i < n && Character.isWhitespace(s.charAt(i))) {
            i++;
        }
        long num = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i) - '0');
            if (sign == 1 && num > Integer.MAX_VALUE) {
                num = Integer.MAX_VALUE;
                break;
            } else if (sign == -1 && num > 1L + Integer.MAX_VALUE) {
                num = 1L + Integer.MAX_VALUE;
                break;
            }
            i++;
        }
        return (int) (num * sign);
    }

    public static void main(String[] args) {

    }
}
