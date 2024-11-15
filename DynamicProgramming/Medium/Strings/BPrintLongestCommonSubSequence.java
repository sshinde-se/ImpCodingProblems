package DynamicProgramming.Medium.Strings;

import java.util.*;

public class BPrintLongestCommonSubSequence {
    public static void main(String[] args){
        String s1 = "aababbb";
        String s2 = "bbbaababababb";

        System.out.println("Longest Common Subsequence is " + printLongestCommonSubsequenceUsingTabulation(s1, s2));

        String s11 = "abaaa";
        String s22 = "baabaca";

        System.out.println("Longest Common Subsequence is " + printLongestCommonSubsequenceUsingTabulation(s11, s22));

    }

    private static List<String> printLongestCommonSubsequenceUsingTabulation(String s, String t) {
        int n=s.length(), m=t.length();
        int[][] dp =new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = 1+ dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        int lcs = dp[n][m];
        System.out.println("Length of Longest Common Subsequence is :"+lcs);

        List<String> list = new ArrayList<>();
        for(int n1=n;n1>0;n1--){
            String ans=null;
            for(int m1=m;m1>0;m1--){
                if(dp[n1][m1] == lcs)
                    ans = findStringFromDp(n1,m1,s,t,dp);
                if(ans!=null){
                    if(!list.contains(ans))
                        list.add(ans);
                }
            }
        }
        Collections.sort(list);
        return list;
    }

    private static String findStringFromDp(int i,int j,String s1,String s2,int[][] dp){
        StringBuilder res = new StringBuilder();
        while (i>0 && j>0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                res.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1])
                i--;
            else
                j--;
        }
        res.reverse();
        return res.toString();
    }
}
