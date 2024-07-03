package ServiceNowCoding;

/*
Given a number N. our task is to find the closest Palindrome number whose absolute difference
with given number is minimum and absolute difference must be greater than 0.
 */

public class ClosestPalindromeNumber {
    public static void main(String[] args){
        int num = 121;
        System.out.println(closestPalindrome(num));
        int num1=1234;
        System.out.println(closestPalindrome(num1));
    }

    static boolean isPalindrome(int i){
        String s = Integer.toString(i);
        int l = 0;
        int r = s.length()-1;
        while (l<r){
            if(s.charAt(l)!=s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
    private static int closestPalindrome(int num) {
        int low = num -1;
        while (!isPalindrome(low)){
            low = low-1;
        }
        int high = num+1;
        while (!isPalindrome(high)){
            high = high+1;
        }
        if(Math.abs(num-low) < Math.abs(high-num))
            return low;
        else
            return high;
    }
}
