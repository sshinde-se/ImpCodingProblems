package DynamicProgramming.Medium.Strings;
import java.util.Arrays;
/*
find the length of the longest palindromic subsequence of a string. It is that palindromic
subsequence of the given string with the greatest length. We need to print the length of the
longest palindromic subsequence.

S1="bbbab"

There can be many subsequences like “b”, “ba”,”bbb” but “bbbb” is the subsequence that is a
palindrome and has the greatest length.

S2="bbabcbcab"
The longest palindromic subsequence will be: “babcbab”.

What is special about this string is that it is palindromic (equal to its reverse) and of the longest length.

Now, we have taken the reverse of the string for the following two reasons:

The longest palindromic subsequence being a palindrome will remain the same when the entire string is reversed.
The length of the palindromic subsequence will also remain the same when the entire string is reversed.
From the above discussion we can conclude:

The longest palindromic subsequence of a string is the longest common subsequence of the given string and its reverse.
 */
public class DLongestPalindromeSubsequence {
    public static void main(String args[]) {
        String s = "bbabcbcab";

        System.out.println("The Length of Longest Palindromic Subsequence is " + longestPalindromeSubsequenceMemo(s));
        System.out.println("The Length of Longest Palindromic Subsequence is " + longestPalindromeSubsequenceTabulation(s));
        System.out.println("The Length of Longest Palindromic Subsequence is " + longestPalindromeSubsequenceSpaceOptimization(s));
    }

    private static int longestPalindromeSubsequenceSpaceOptimization(String s) {
        String t= new StringBuilder(s).reverse().toString();
        int n=s.length();
        int[] dp = new int[n+1];

        for(int i=1;i<=n;i++){
            int[] tmp = new int[n+1];
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    tmp[j] = 1 + dp[j-1];
                }
                else
                    tmp[j] = Math.max(dp[j],tmp[j-1]);
            }
            dp=tmp;
        }
        return dp[n];
    }

    private static int longestPalindromeSubsequenceTabulation(String s) {
        String t= new StringBuilder(s).reverse().toString();
        int n=s.length();
        int[][] dp = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[n][n];
    }

    private static int longestPalindromeSubsequenceMemo(String s) {
        String t= new StringBuilder(s).reverse().toString();

        int n=s.length();
        int[][] dp = new int[n][n];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return lcs(n-1,n-1,s,t,dp);
    }
    private static int lcs(int i,int j, String s1, String s2,int[][] dp){
        if(i<0 || j<0)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = 1+ lcs(i-1,j-1,s1,s2,dp);
        return dp[i][j] = Math.max(lcs(i-1,j,s1,s2,dp), lcs(i,j-1,s1,s2,dp));
    }
}
