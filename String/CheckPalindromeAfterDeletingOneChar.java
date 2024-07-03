package String;

public class CheckPalindromeAfterDeletingOneChar {
    public static boolean validPalindrome(String s) {
        int start = 0;
        int last = s.length() - 1;
        while(start < last){
            if(s.charAt(start) != s.charAt(last))
                return isPalindrome(s, start + 1, last) || isPalindrome(s, start, last - 1);
            start++;
            last--;

        }
        return true;
    }
    private static boolean isPalindrome(String s, int i, int j)
    {
        while(i<j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String [] args){
        String s = "abcdba";
        if(validPalindrome(s))
            System.out.println("String is palindrome");
        else
            System.out.println("String is not palindrome");
    }
}
