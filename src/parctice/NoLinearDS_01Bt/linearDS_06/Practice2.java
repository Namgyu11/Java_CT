package parctice.NoLinearDS_01Bt.linearDS_06;// Practice2
// 괄호 짝 검사

// 입출력 예시)
// 입력: "("
// 출력: Fail

// 입력: ")"
// 출력: Fail

// 입력: "()"
// 출력: Pass

import java.util.Stack;

public class Practice2 {
    public static void checkParenthesis(String str) {
//        Stack stack = new Stack<>();
//        String result = "";
//        int count = 0;
//        for (String s: str.split("")) {
//            stack.push(s);
//        }
//
//        while(!stack.isEmpty()){
//            result = "" +stack.pop();
//            if (result.equals(")")){
//                count -=1;
//            }else if(result.equals("(")){
//                count +=1;
//            }
//        }
//        if(count == 0){
//            System.out.println("PASS!");
//        }else {
//            System.out.println("FAIL!");
//        }
        Stack stack = new Stack<>();
        boolean checkFlag = true;
        for (String s: str.split("")) {
            if(s.equals("(")){
                stack.push(s);
            }else {
                if(stack.isEmpty()){
                    checkFlag =false;
                    break;
                }else {
                    stack.pop();
                }
            }
        }
        if(checkFlag && stack.isEmpty()){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
    }

    public static void main(String[] args) {
        // Test code
        checkParenthesis("(");          // FAIL!
        checkParenthesis(")");          // FAIL!
        checkParenthesis("()");         // PASS!
        checkParenthesis("()()()");     // PASS!
        checkParenthesis("(())()");     // PASS!
        checkParenthesis("(((()))");    // FAIL!
    }
}
