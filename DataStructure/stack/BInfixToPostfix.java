package DataStructure.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BInfixToPostfix {
    public static void main(String []args){
        String infixStr = "a-b+c";
        String postfixStr = convertInfixToPostFix(infixStr);
        System.out.println(postfixStr);
    }

    static String convertInfixToPostFix(String infixStr){
        Deque<Character> stack = new ArrayDeque<Character>();
        StringBuilder result = new StringBuilder();
        for(int i=0; i<infixStr.length(); i++){
            char c = infixStr.charAt(i);
            if(Character.isLetterOrDigit(c)){
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '('){
                    result.append(stack.peek());
                    stack.pop();
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())){
                    result.append(stack.peek());
                    stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return "invalid expression";
            result.append(stack.peek());
            stack.pop();
        }
        return result.toString();
    }

    static int precedence(char c){
        switch (c){
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }
}
