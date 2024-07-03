package DataStructure.stack;

import java.util.Stack;

public class GBasicCalculator {

    public static void main(String [] args){
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(s));
        String s1 = "2147483647";
        System.out.println(calculate(s1));
        String s2 = "1-(     -2)";
        System.out.println(calculate(s2));
        String s3 = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculateEfficient(s3));
        String s4 = "2147483647";
        System.out.println(calculateEfficient(s4));
        String s5 = "1-(     -2)";
        System.out.println(calculateEfficient(s5));
    }

    public static int calculateEfficient(String s){
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        int res = 0;
        int sign = 1;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = 10 * number + (c - '0');
            } else if (c == '+') {
                res += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                res += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res += sign * number;
                number = 0;
                res *= stack.pop();
                res += stack.pop();
            }
        }
        if(number != 0)
            res += sign * number;
        return res;
    }

    public static int calculate(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        String res = "";
        for(int i=0; i<s.length();i++){
            char x = s.charAt(i);
            if(Character.isDigit(x)){
                res += x;
            }
            else if(x == '('){
                stack.push(x);
            }
            else if(x == ')'){
                char c = stack.pop();
                while(!stack.isEmpty() && c != '('){
                    res += c;
                    c = stack.pop();
                }
            }
            else{
                if(x != ' '){
                    while(!stack.isEmpty() && stack.peek() != '('){
                        res += stack.pop();
                    }
                    stack.push(x);
                }
            }
        }
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        int val=0;
        try{
            val = Integer.parseInt(res);
            return val;
        }
        catch (NumberFormatException e) {
            if (res.length() == 1)
                return Integer.parseInt(res);
            for (int i = 0; i < res.length(); i++) {
                char c = res.charAt(i);
                if (Character.isDigit(c))
                    stack1.push(c - '0');
                else {
                    int p2 = 0;
                    int p1 = stack1.pop();
                    if (stack1.isEmpty() && c == '-')
                        val = p1 * -1;
                    else
                        p2 = stack1.pop();
                    if (c == '+')
                        val = p2 + p1;
                    else if (c == '-')
                        val = p2 - p1;
                    stack1.push(val);
                }
            }
        }
        return stack1.pop();
    }
}
