package parctice.linearDS_02.linearDS_06;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack);

        stack.pop();
        System.out.println(stack);

        System.out.println(stack.peek());
        System.out.println(stack);


    }


}
