package DynamicProgramming1;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    public static void main(String[] args){
        String s="leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s, wordDict));
        System.out.println(wordBreakRecursion(s, wordDict));
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()] = true;
        for(int i=s.length()-1; i>=0; i--){
            for(String w:wordDict){
                if(i+w.length()<=s.length() && s.startsWith(w, i)){
                    dp[i] = dp[i+w.length()];
                }
                if(dp[i])
                    break;
            }
        }
        return dp[0];
    }

    //Exceeds time limit
    static boolean wordBreakRecursion(String s, List<String> wordDict){
        if(s.isEmpty())
            return true;
        int len = s.length();
        for(int i=0;i<=len;i++){
            String prefix = s.substring(0,i);
            if(wordDict.contains(prefix) && wordBreakRecursion(s.substring(i), wordDict))
                return true;
        }
        return false;
    }
}
