package String;

import java.util.Stack;

public class CheckPalindrome {
    public static boolean isPalindrome(String s) {
        int first = 0;
        int last = s.length()-1;
        while (first <= last){
            char cFirst = s.charAt(first);
            char cLast = s.charAt(last);
            if(!Character.isLetterOrDigit(cFirst))
                first++;
            else if(!Character.isLetterOrDigit(cLast))
                last--;
            else {
                if(Character.toLowerCase(cFirst) != Character.toLowerCase(cLast))
                    return false;
                first++;
                last--;
            }
        }
        return true;
    }
    public static void main(String [] args){
        String s = "A man, a plan, a canal: Panama";
        if(isPalindrome(s))
            System.out.println("String is palindrome");
        else
            System.out.println("String is not palindrome");
    }
}
