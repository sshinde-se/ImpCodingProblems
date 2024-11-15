package DynamicProgramming.Medium.Strings;
import java.util.Arrays;
/*
We need to find the minimum insertions required to make a string palindrome
To minimize the insertions, we will first try to refrain from adding those characters again which
are already making the given string palindrome. For the given example, “aaa”, “aba”,”aca”, any of
these are themselves palindromic components of the string. We can take any of them( as all are of
equal length) and keep them intact. (let’s say “aaa”).

Now, there are two characters(‘b’ and ‘c’) remaining which prevent the string from being a
palindrome. We can reverse their order and add them to the string to make the entire string
palindrome.

like abcacba

We can do this by taking some other components (like “aca”) as well.

In order to minimize the insertions, we need to find the length of the longest palindromic component or in other words, the longest palindromic subsequence.

Minimum Insertion required = n(length of the string) - length of longest palindromic subsequence.
 */
public class EMinInsertionsToMakeStringPalindrome {
    public static void main(String args[]) {
        String s = "abcaa";
        System.out.println("The Minimum insertions required to make the string palindrome: "
                + minInsertionsMemo(s));
        System.out.println("The Minimum insertions required to make the string palindrome: "
                + minInsertionsTabulation(s));
        System.out.println("The Minimum insertions required to make the string palindrome: "
                + minInsertionsSpaceOptimization(s));
    }

    private static int minInsertionsSpaceOptimization(String s) {
        String t=new StringBuilder(s).reverse().toString();
        int n=s.length();

        int[] dp = new int[n+1];

        for(int i=1;i<=n;i++){
            int[] tmp = new int[n+1];
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == t.charAt(j-1))
                    tmp[j] = 1 + dp[j-1];
                else
                    tmp[j] = Math.max(dp[j], tmp[j-1]);
            }
            dp=tmp;
        }
        return n-(dp[n]);
    }

    private static int minInsertionsTabulation(String s) {
        String t=new StringBuilder(s).reverse().toString();
        int n=s.length();

        int[][] dp = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return n-(dp[n][n]);
    }

    public static int minInsertionsMemo(String s) {
        int n=s.length();
        String t= new StringBuilder(s).reverse().toString();

        int[][] dp = new int[n][n];
        for(int[] row: dp)
            Arrays.fill(row,-1);
        return n-(lcs(n-1,n-1,s,t,dp));
    }
    static int lcs(int i,int j,String s,String t,int[][] dp){
        if(i<0 || j<0)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(s.charAt(i) == t.charAt(j))
            return dp[i][j] = 1 + lcs(i-1,j-1,s,t,dp);
        return dp[i][j] = Math.max(lcs(i-1,j,s,t,dp), lcs(i,j-1,s,t,dp));
    }
}
