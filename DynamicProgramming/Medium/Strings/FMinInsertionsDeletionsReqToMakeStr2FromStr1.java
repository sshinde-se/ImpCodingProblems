package DynamicProgramming.Medium.Strings;
import java.util.Arrays;
/*
We are given two strings, str1 and str2. We are allowed the following operations:

Delete any number of characters from string str1.
Insert any number of characters in string str1.
We need to tell the minimum operations required to convert str1 to str2.

The easiest way is to remove all the characters of str1 and then insert all the characters of str2.
In this way, we will convert str1 to str2 with ‘n+m’ operations. (Here n and m are the length of
strings str1 and str2 respectively).

The problem states us to find the minimum of insertions. Let us try to figure it out:

To minimize the operations, we will first try to refrain from deleting those characters which are already
present in str2. More extensively, we refrain from deleting those characters which are common and
come in the same order. To minimize the operations, we would like to keep the maximum common
characters coming in the same order intact. These maximum characters are the characters of the
longest common subsequence.

We will first keep the longest common subsequence of the str1 and str2 intact in str1 and
delete all other characters from str1.

In order to minimize the operations, we need to find the length of the longest common subsequence.

Minimum Operations required = (n - k) + (m - k)

Here n and m are the length of str1 and str2 respectively and k is the length of the longest
common subsequence of str1 and str2.
 */
public class FMinInsertionsDeletionsReqToMakeStr2FromStr1 {
    public static void main(String args[]) {
        String str1 = "abcd";
        String str2 = "anc";

        System.out.println("Minimum operations required to convert str1 to str2: "
                + minInsertionsDeletionsToMakeStr2FromStr1Memo(str1, str2));
        System.out.println("Minimum operations required to convert str1 to str2: "
                + minInsertionsDeletionsToMakeStr2FromStr1Tabulation(str1, str2));
        System.out.println("Minimum operations required to convert str1 to str2: "
                + minInsertionsDeletionsToMakeStr2FromStr1SpaceOptimization(str1, str2));
    }

    private static int minInsertionsDeletionsToMakeStr2FromStr1SpaceOptimization(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();

        int[] dp = new int[m+1];

        for(int i=1;i<=n;i++){
            int[] tmp = new int[m+1];
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    tmp[j] = 1 + dp[j-1];
                else
                    tmp[j] = Math.max(dp[j], tmp[j-1]);
            }
            dp=tmp;
        }
        int insertions = n - dp[m];
        int deletions = m - dp[m];
        return insertions + deletions;
    }

    private static int minInsertionsDeletionsToMakeStr2FromStr1Tabulation(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        int insertions = n - dp[n][m];
        int deletions = m - dp[n][m];
        return insertions + deletions;
    }

    private static int minInsertionsDeletionsToMakeStr2FromStr1Memo(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();

        int[][] dp = new int[n][m];
        for(int[] row: dp)
            Arrays.fill(row,-1);
        int l = lcs(n-1,m-1,word1,word2,dp);
        int deletions = n-l;
        int insertions = m-l;
        return insertions+deletions;
    }
    private static int lcs(int i,int j,String s, String t,int[][] dp){
        if(i<0 || j<0)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(s.charAt(i) == t.charAt(j))
            return dp[i][j] = 1 + lcs(i-1,j-1,s,t,dp);
        return dp[i][j] = Math.max(lcs(i-1,j,s,t,dp), lcs(i,j-1,s,t,dp));
    }
}
