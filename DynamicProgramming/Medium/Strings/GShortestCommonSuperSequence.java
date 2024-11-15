package DynamicProgramming.Medium.Strings;
/*
We are given two strings ‘S1’ and ‘S2’. We need to return their shortest common supersequence.
A supersequence is defined as the string which contains both the strings S1 and S2 as subsequences.

ex
s1: "brute"
s2: "groot"

shortest common supersequence = "bgruoote"

If we think a little, there are some common characters that we can avoid writing for both the strings
separately. These common characters can’t be all the common characters. They are the characters that
are common and come in the same order. In other words, they are the characters of the longest common
subsequence.

In an optimum solution, the characters of the longest common subsequence are written only once and
other characters are placed around them. For every character that belongs to the longest common
subsequence, the non-lcs characters coming before them in the strings S1 and S2 are placed before
the lcs-character in the answer string.

To form the string, we will work in a reverse manner.

1. if(S1[i-1] == S2[j-1]), this means the character is an lcs character and needs to be included only
   once from both the strings, so we add it to the ans string and reduce both i and j by 1. We reduce
   them simultaneously to make sure the character is counted only once.
2. if(S1[i-1] != S2[j-1]), this means that the character is a non-lcs character and then we move the
 pointer to the top cell or left cell depending on which is greater. This way non-lcs characters will
 be included separately in the right order.

 This question is combination of LCS and printing lcs with leftover char in both strings
 */
public class GShortestCommonSuperSequence {
    public static void main(String[] args) {

        String s1 = "brute";
        String s2 = "groot";

        System.out.println("The Longest Common Supersequence is "+shortestCommonSupersequence(s1,s2));
    }

    public static String shortestCommonSupersequence(String str1, String str2) {
        int n=str1.length(),m=str2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        int i=n,j=m;
        StringBuilder res = new StringBuilder();
        while(i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                res.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                res.append(str1.charAt(i-1)); //it is added as we are computing supersequnce
                i--;
            }
            else
            {
                res.append(str2.charAt(j-1)); //it is added as we are computing supersequnce
                j--;
            }
        }
        while(i>0){
            res.append(str1.charAt(i-1)); //it is added as we are computing supersequnce
            i--;
        }
        while(j>0){
            res.append(str2.charAt(j-1)); //it is added as we are computing supersequnce
            j--;
        }
        return res.reverse().toString();
    }
}
