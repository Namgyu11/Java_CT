package ktb_ct.week06.week05.week04.week03.week02.ct01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < T; i++) {
                  String ps = br.readLine();
                  if (isValid(ps)) {
                        sb.append("YES").append("\n");
                  } else {
                        sb.append("NO").append("\n");
                  }
            }

            System.out.println(sb);
      }

      public static boolean isValid(String ps) {
            Stack<Character> stack = new Stack<>();

            for (char ch : ps.toCharArray()) {
                  if (ch == '(') {
                        stack.push(ch);
                  } else if (ch == ')') {
                        if (stack.isEmpty()) {
                              return false;
                        }
                        stack.pop();
                  }
            }

            return stack.isEmpty();
      }
}


