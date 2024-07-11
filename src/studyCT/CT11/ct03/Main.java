package studyCT.CT11.ct03;

import java.io.*;
import java.util.*;

public class Main {
      public static void main(String[] args) {
            String[] testCases = {
                    "33(562(71(9)))",
                    "123",
                    "10342(76)",
                    "0(0)",
                    "1(1(1(1(1(1(1(0(1234567890))))))))",
                    "1()66(5)"
            };

            for (String testCase : testCases) {
                  System.out.println(decompressedLength(testCase));
            }
      }

      public static int decompressedLength(String s) {
            Stack<Integer> lengthStack = new Stack<>();
            Stack<Integer> repeatStack = new Stack<>();
            int length = 0;
            int i = 0;

            while (i < s.length()) {
                  char ch = s.charAt(i);

                  if (Character.isDigit(ch)) {
                        int start = i;
                        while (i < s.length() && Character.isDigit(s.charAt(i))) {
                              i++;
                        }
                        int number = Integer.parseInt(s.substring(start, i));
                        if (i < s.length() && s.charAt(i) == '(') {
                              repeatStack.push(number);
                              lengthStack.push(length);
                              length = 0;
                        } else {
                              length += number;
                              i--;
                        }
                  } else if (ch == ')') {
                        int k = repeatStack.pop();
                        int previousLength = lengthStack.pop();
                        length = previousLength + k * length;
                  } else if (ch == '(') {
                  } else {
                        length++;
                  }
                  i++;
            }

            return length;
      }
}
