package String;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if(x<0)
            return false;
        String s=Integer.toString(x);
        int first=0;
        int last=s.length()-1;
        while(first<=last){
            char ch1 = s.charAt(first);
            char ch2 = s.charAt(last);
            if(ch1 == ch2)
            {
                first++;
                last--;
            }
            else
                return false;
        }
        return true;
    }

    public static void main(String []args){
        int a= -121;
        System.out.println(isPalindrome(a));
        int b= 11;
        System.out.println(isPalindrome(b));
        int c= 1221;
        System.out.println(isPalindrome(c));
    }
}
