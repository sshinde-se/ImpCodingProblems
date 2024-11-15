package DynamicProgramming.Medium.Strings;

import java.util.Arrays;

/*
A subsequence of a string is a list of characters of the string where some characters are deleted
( or not deleted at all) and they should be in the same order in the subsequence as in the original
string.

String: "abc"

SubSequences: {"", "a", "b","c","ab","bc","ac","abc"} = 2^(lengthOfString)= 2^3=8
Strings like “cab”,” bc” will not be called as a subsequence of “abc” as the characters are not
coming in the same order.

s1="adebc", s2="dcadb"
LCS: "adb"
 */
public class ALongestCommonSubSequence {
    public static void main(String[] args){
        String s1 = "aababbb";
        String s2 = "bbbaababababb";

        System.out.println("The Length of Longest Common Subsequence is " + longestCommonSubsequenceMemo(s1, s2));
        System.out.println("The Length of Longest Common Subsequence is " + longestCommonSubsequenceUsingTabulation(s1, s2));
        System.out.println("The Length of Longest Common Subsequence is " + longestCommonSubsequenceUsingSpaceOptimization(s1, s2));
    }

    private static int longestCommonSubsequenceUsingSpaceOptimization(String s1, String s2) {
        int n=s1.length(),m=s2.length();
        int[] dp = new int[m+1];
        for(int i=1;i<=n;i++){
            int[] tmp = new int[m+1];
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    tmp[j] = 1 + dp[j-1];
                else
                    tmp[j] = Math.max(dp[j], tmp[j-1]);
            }
            dp = tmp;
        }
        return dp[m];
    }

    private static int longestCommonSubsequenceUsingTabulation(String s1, String s2) {
        int n=s1.length(),m=s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[n][m];
    }

    private static int longestCommonSubsequenceMemo(String s1, String s2) {
        int n=s1.length(),m=s2.length();
        int[][] dp = new int[n][m];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return lcs(n-1,m-1,s1,s2,dp);
    }

    private static int lcs(int i, int j, String s1, String s2, int[][] dp) {
        if(i<0 || j<0)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = 1 + lcs(i-1,j-1,s1,s2,dp);
        return dp[i][j] = Math.max(lcs(i-1,j,s1,s2,dp), lcs(i,j-1,s1,s2,dp));
    }
}

