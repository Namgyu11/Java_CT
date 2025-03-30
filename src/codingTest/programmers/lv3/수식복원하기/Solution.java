package codingTest.programmers.lv3.수식복원하기;

import java.util.*;
class Solution {
    public String[] solution(String[] expressions) {
        int maxDigit = -1;

        for(String expr : expressions){
            String[] parts = expr.split(" ");
            for(char ch : parts[0].toCharArray()){
                maxDigit = Math.max(maxDigit, ch - '0');
            }
            for(char ch : parts[2].toCharArray()){
                maxDigit = Math.max(maxDigit, ch - '0');
            }
            if(!parts[4].equals("X")){
                for(char ch : parts[4].toCharArray()){
                    maxDigit = Math.max(maxDigit, ch - '0');
                }
            }
        }

        int minBase = maxDigit + 1;
        List<Integer> possibleBases = new ArrayList<>();

        for(int b = Math.max(minBase,2); b <= 9; b++){
            possibleBases.add(b);
        }

        List<Integer> validBases = new ArrayList<>(possibleBases);

        for(String expr : expressions){
            String[] parts = expr.split(" ");
            if(!parts[4].equals("X")){
                List<Integer> next = new ArrayList<>();
                for(int b : validBases){
                    if(validNumber(parts[0], b) && validNumber(parts[2], b) && validNumber(parts[4], b)){
                        int a = convert(parts[0], b);
                        int bnum = convert(parts[2], b);
                        int c = convert(parts[4], b);
                        int result = parts[1].equals("+") ? a + bnum : a - bnum;
                        if (result == c) {
                            next.add(b);
                        }
                    }
                }
                validBases = next;
            }
        }

        List<String> ansList = new ArrayList<>();

        for(String expr : expressions){
            String[] parts = expr.split(" ");
            if(parts[4].equals("X")){
                Set<String> outcomes = new HashSet<>();
                for(int b : validBases){
                    if(validNumber(parts[0], b) && validNumber(parts[2], b)){
                        int a = convert(parts[0], b);
                        int bnum = convert(parts[2], b);
                        int result = parts[1].equals("+") ? a + bnum : a - bnum;
                        outcomes.add(toBaseString(result, b));
                    }
                }
                String res = outcomes.size() == 1 ? outcomes.iterator().next() : "?";
                ansList.add(parts[0] + " " + parts[1] + " " + parts[2] + " = " + res);
            }
        }
        return ansList.toArray(new String[0]);
    }
    boolean validNumber(String s, int base) {
        for(char ch : s.toCharArray()){
            if (ch < '0' || ch > '9') {
                return false;
            }
            if (ch - '0' >= base) {
                return false;
            }
        }
        return true;
    }
    int convert(String s, int base) {
        int num = 0;
        for(char ch : s.toCharArray()){
            num = num * base + (ch - '0');
        }
        return num;
    }
    String toBaseString(int num, int base) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            sb.append(num % base);
            num /= base;
        }
        return sb.reverse().toString();
    }
}
