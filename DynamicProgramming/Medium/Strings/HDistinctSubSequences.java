package DynamicProgramming.Medium.Strings;

import java.util.Arrays;

/*
Given 2 strings s1 and s2 find count of how many times string s2 appear in string s1

https://youtu.be/nVG7eTiD2bY
for tabulation see solution from 22.25
 */
public class HDistinctSubSequences {
    public static void main(String args[]) {
        String s1 = "babgbag";
        String s2 = "bag";

        System.out.println("Count of Distinct Subsequences is " + subsequenceCountingMemo(s1, s2));
        System.out.println("Count of Distinct Subsequences is " + subsequenceCountingTabulation(s1, s2));
        System.out.println("Count of Distinct Subsequences is " + subsequenceCountingSpaceOptimization(s1, s2));
    }

    private static int subsequenceCountingSpaceOptimization(String s1, String s2) {
        int n=s1.length(),m=s2.length();
        int[] dp = new int[m+1];
        // Initialize the first element to 1 because there's one empty subsequence in any string.
        dp[0] =1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[j] = dp[j-1] + dp[j];
                else
                    dp[j] = dp[j];
            }
        }
        return dp[m];
    }

    private static int subsequenceCountingTabulation(String s1, String s2) {
        /*In the recursive logic, we set the base case too if(i<0 ) and if(j<0) but we can’t set the
        dp array’s index to -1. Therefore a hack for this issue is to shift every index by 1 towards
        the right.
        Next, we set the base condition (keep in mind 1-based indexing), we set the first column’s
        value as 1 and the first row as 1.*/
        int n=s1.length(),m=s2.length();
        int[][] dp = new int[n+1][m+1];
        // Initialize the first column with 1 because there's one empty subsequence in any string.
        for(int i=0;i<n+1;i++){
            dp[i][0] = 1;
        }
        // Initialize the first row (except dp[0][0]) with 0 because there's no way to form s2 from an empty string.
        for(int j=1;j<m+1;j++){
            dp[0][j] = 0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][m];
    }

    private static int subsequenceCountingMemo(String s1, String s2) {
        int n=s1.length(),m=s2.length();
        int[][] dp = new int[n][m];
        for(int[] row: dp)
            Arrays.fill(row,-1);
        return distinctLCS(n-1,m-1,s1,s2,dp);
    }

    private static int distinctLCS(int i, int j, String s1, String s2, int[][] dp) {
        if(j<0)
            return 1;
        if(i<0)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = distinctLCS(i-1,j-1,s1,s2,dp) + distinctLCS(i-1,j,s1,s2,dp);
        return dp[i][j] = distinctLCS(i-1,j,s1,s2,dp);
    }
}
