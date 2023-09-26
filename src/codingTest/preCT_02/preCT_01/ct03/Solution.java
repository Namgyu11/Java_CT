package codingTest.preCT_02.preCT_01.ct03;

import java.util.HashMap;

// 23.09.26(풀이) -- 다시 풀기
public class Solution {
    public static boolean solution(String p, String s) {
        HashMap<Character, String> cmap = new HashMap<>();
        HashMap<String , Character> smap = new HashMap<>();
        String[] str = s.split(" ");

        if(p.length() != str.length) return false;

        for (int i = 0; i <p.length(); i++) {
            char c = p.charAt(i);
            if(cmap.containsKey(c)){
                if(!cmap.get(c).equals(str[i])){
                    return false;
                }
            }else {
                if(smap.containsKey(str[i]) && smap.get(str[i]) !=c){
                    return false;
                }
                cmap.put(c,str[i]);
                smap.put(str[i],c);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String p = "갸가갸가";
        String s = "금도끼 은도끼 철도끼 은도끼";

        System.out.println(solution(p,s));

    }

}
