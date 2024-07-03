package DataStructure.stack;


import java.util.Stack;

public class FPalindromeUsingStack {
    public static boolean isPalindrome(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                stack.push(Character.toLowerCase(c));
            }
        }
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                if(Character.toLowerCase(c) != stack.pop())
                    return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String [] args){
        String s = "A man, a plan, a canal: Panama";
        if(isPalindrome(s))
            System.out.println("String is palindrome");
        else
            System.out.println("String is not palindrome");
    }
}