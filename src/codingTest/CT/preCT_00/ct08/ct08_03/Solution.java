package codingTest.CT.preCT_00.ct08.ct08_03;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static int solution(String S1, String S2) {
        int answer;
        String temp1 = "";
        String temp2 = "";
        Queue<String> queue = new LinkedList<>();
        String[] str1 = S1.split("");
        String[] str2 = S2.split("");
        for (String s : str2){
            queue.add(s);
        }
        if(str1.length % 2 != 0){
            for (int i = str1.length/2 + 1; i < str1.length; i++) {
                if(str1[i].equals(queue.peek())){
                    temp2+=str1[i];
                    queue.remove();
                }else{
                    if(i != str1.length -1) {
                        temp2 += str1[i-1];
                        queue.remove();
                    }else {
                        temp2 += str1[i-1];
                        queue.remove();
                        temp2 += str1[i];
                        queue.remove();
                    }
                }
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if(str1[i].equals(queue.remove())){
                    temp1+=str1[i];
                }
            }

        }else {
            for (int i = str1.length/2; i < str1.length; i++) {
                if(str1[i].equals(queue.remove())){
                    temp2+=str1[i];
                }
            }
            for (int i = 0; i < str1.length/2; i++) {
                if(str1[i].equals(queue.remove())){
                    temp1+=str1[i];
                }
            }
        }
        if(S1.equals(temp1+temp2)){
            answer = 1;
        }else {
            answer = 0;
        }
        System.out.println(temp1);
        System.out.println(temp2);
        return answer;
    }

    public static void main(String[] args) {
        String a = "LoveI";
        String b = "ILove";
        System.out.println(solution(a,b));

    }
}
