package programmers.lv2;

import java.util.Stack;

public class 올바른_괄호 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack();

        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if(cur == '(') stack.push(cur);
            else {
                if(stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
