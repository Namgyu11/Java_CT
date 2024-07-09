package studyCT.CT11.ct02;

import java.io.*;
import java.util.*;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            Stack<Character> stack = new Stack<>();
            String input = st.nextToken();

            int pieceCount = 0;

            for (int i = 0; i < input.length(); i++) {
                  char c = input.charAt(i);

                  if (c == '(') {
                        stack.push(c);
                  } else {
                        stack.pop();
                        if (input.charAt(i - 1) == '(') { // 이전 문자가 여는 괄호면 레이저로 간주
                              pieceCount += stack.size();
                        } else {  // 이전 문자가 닫는 괄호면 쇠막대기의 끝으로 간주
                              pieceCount += 1;
                        }
                  }
            }

            System.out.println(pieceCount);
      }
}
