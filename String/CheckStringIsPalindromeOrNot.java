package String;

public class CheckStringIsPalindromeOrNot {
    public static void main(String [] args){
        String s = "madam";
        if(isPalindrome(s))
            System.out.println("String is palindrome");
        else
            System.out.println("String is not palindrome");
        if(isPalindromeUsingReversingString(s))
            System.out.println("String is palindrome");
        else
            System.out.println("String is not palindrome");
        if(isPalindromeUsingStringBuilder(s))
            System.out.println("String is palindrome");
        else
            System.out.println("String is not palindrome");
    }
    private static boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        boolean flag=true;
        while (start<end){
            if (s.charAt(start) != s.charAt(end)) {
                flag = false;
                break;
            }
            start++;
            end--;
        }
        return flag;
    }
    private static boolean isPalindromeUsingStringBuilder(String s){
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.reverse();
        return stringBuilder.toString().equals(s);
    }
    private static boolean isPalindromeUsingReversingString(String s){
        String newString = "";
        for(int i=s.length()-1;i>=0;i--){
            newString = newString + s.charAt(i);
        }
        return newString.equals(s);
    }
}
