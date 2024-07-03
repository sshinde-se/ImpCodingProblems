package DataStructure.stack;

import java.util.Stack;

public class CPostfixEvaluation {
    public static void main(String [] args){
        String exp = "123*+5-";
        int result = calculatePostFixExpression(exp);
        System.out.println(result);
        String [] s = new String[]{"2","1","+","3","*"};
        System.out.println(evalRPN(s));
    }

    static Integer calculatePostFixExpression(String exp){
        Stack<Integer> stack = new Stack<>();
        for(char c: exp.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                stack.push(c - '0');
            }
            else{
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                int result=0;
                if(c == '+')
                    result = operand2 + operand1;
                else if (c == '-')
                    result = operand2 - operand1;
                else if (c == '*')
                    result = operand2 * operand1;
                else if(c == '/')
                    result = operand2 / operand1;

                stack.push(result);
            }
        }
        return stack.pop();
    }

    static Stack<Integer> stack = new Stack<>();
    public static int evalRPN(String[] tokens) {

        int res = 0;
        for(String s: tokens){
            if(s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")){
                res = calculateExp(s);
                stack.push(res);
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }
        return res;
    }
    public static int calculateExp(String s){
        int p1 = stack.pop();
        int p2 = stack.pop();
        int res = 0;
        switch(s){
            case "+":
                res = p2 + p1;
                break;
            case "-":
                res = p2 - p1;
                break;
            case "*":
                res = p2 * p1;
                break;
            case "/":
                res = p2 / p1;
                break;
        }
        return res;
    }
}
