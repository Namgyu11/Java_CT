package studyCT.CT11.ct01;

import java.io.*;
import java.util.*;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            String s = st.nextToken();

            Stack<Character> stack = new Stack<>();

            int openNeeded = 0; // 필요한 여는 괄호 '('의 수

            for (char c : s.toCharArray()) {
                  if (c == '(') {
                        stack.push(c);
                  } else {
                        if (stack.isEmpty()) {
                              openNeeded++; // 스택이 비어 있으면 여는 괄호가 필요
                        } else {
                              stack.pop(); // 스택에 여는 괄호가 있으면 짝 맞추기
                        }
                  }
            }

            int closeNeeded = stack.size(); // 스택에 남아 있는 여는 괄호의 수가 닫는 괄호 ')'의 수

            // 짝이 없은 여는 괄호와 닫는 괄호의 수를 더해서 출력
            System.out.println(openNeeded + closeNeeded);
      }


      public static void main2() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            String s = st.nextToken();

            int openNeeded = 0; // 필요한 여는 괄호 '('의 수
            int closeNeeded = 0; // 필요한 닫는 괄호 ')'의 수
            int balance = 0; // 괄호의 균형을 맞추기 위한 변수

            for(char c: s.toCharArray()){
                  if(c == '('){
                        balance++;
                  }else {
                        balance--;
                  }

                  if(balance < 0){
                        openNeeded++;
                        balance = 0;
                  }
            }

            closeNeeded = balance;

            System.out.println(openNeeded + closeNeeded);

      }


}
