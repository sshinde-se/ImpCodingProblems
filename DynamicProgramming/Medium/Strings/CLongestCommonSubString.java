package DynamicProgramming.Medium.Strings;
/*
A substring of a string is a subsequence in which all the characters are consecutive.
Given two strings, we need to find the longest common substring.

S1="abcjklp", S2="acjkp"

Subsequence: "acjkp"
Substring: "cjk"

We need to print the length of the longest common substring.


While finding the longest common subsequence, we were using two pointers (ind1 and ind2) to map
the characters of the two strings. We will again have the same set of conditions for finding the
longest common substring, with slight modifications to what we do when the condition becomes true.

We have two conditions:

1. if(S1[i-1] != S2[j-1]), the characters don’t match, therefore the consecutiveness of characters is
    broken. So we set the cell value (dp[i][j]) as 0.
2. if(S1[i-1] == S2[j-1]), then the characters match and we simply set its value to 1+dp[i-1][j-1].
We have done so because dp[i-1][j-1] gives us the longest common substring till the last cell character
(current strings -{matching character}). As the current cell’s character is matching we are adding 1 to
the consecutive chain.

Note: dp[n][m] will not give us the answer; rather the maximum value in the entire dp array will give
us the length of the longest common substring. This is because there is no restriction that the longest
common substring is present at the end of both the strings.
 */
public class CLongestCommonSubString {
    public static void main(String args[]) {
        String s1 = "abcjklp";
        String s2 = "acjkp";

        System.out.println("The Length of Longest Common Substring is " + lengthOfLongestCommonSubstringTabulation(s1, s2));
        System.out.println("The Length of Longest Common Substring is " + lengthOfLongestCommonSubstringSpaceOptimization(s1, s2));
    }

    private static int lengthOfLongestCommonSubstringSpaceOptimization(String s1, String s2) {
        int n=s1.length(),m=s2.length();
        int[] dp =new int[m+1];

        int ans=0;

        for(int i=1;i<=n;i++){
            int[] tmp =new int[m+1];
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    tmp[j] = 1 + dp[j-1];
                    ans = Math.max(ans, tmp[j]);
                }
                else
                    tmp[j] = 0;
            }
            dp=tmp;
        }
        return ans;
    }

    private static int lengthOfLongestCommonSubstringTabulation(String s1, String s2) {
        int n=s1.length(),m=s2.length();
        int[][] dp =new int[n+1][m+1];

        int ans=0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    ans = Math.max(ans, dp[i][j]);
                }
                else
                    dp[i][j] = 0;
            }
        }
        return ans;
    }
}
