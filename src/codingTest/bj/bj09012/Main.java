package codingTest.bj.bj09012;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void solution(String str) {
        Stack stack = new Stack<>();
        boolean flag = true;
        for (String s : str.split("")) {
            if (s.equals("(")) {
                stack.push(s);
            } else {
                if (stack.isEmpty()) {
                    flag = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        if (flag && stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            solution(sc.next());
        }

    }
}
