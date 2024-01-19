package codingTest.CT.CT15.ct01;
import java.util.regex.Pattern;

//24-01-19(풀이) - 다시 풀기
public class Solution {
    public boolean solution(String s) {
        if (s.length() < 6 || s.length() > 20) {
            return false;
        }
        if (!Pattern.compile("[a-z]").matcher(s).find() ||
                !Pattern.compile("[A-Z]").matcher(s).find() ||
                !Pattern.compile("[0-9]").matcher(s).find() ||
                !Pattern.compile("[!@#$%^&*()]").matcher(s).find()) {
            return false;
        }
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) == s.charAt(i+1) && s.charAt(i+1) == s.charAt(i+2)) {
                return false;
            }
            if (Character.isLetterOrDigit(s.charAt(i)) &&
                    Character.isLetterOrDigit(s.charAt(i+1)) &&
                    Character.isLetterOrDigit(s.charAt(i+2)) &&
                    Math.abs(Character.toLowerCase(s.charAt(i)) - Character.toLowerCase(s.charAt(i+1))) == 1 &&
                    Math.abs(Character.toLowerCase(s.charAt(i+1)) - Character.toLowerCase(s.charAt(i+2))) == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
