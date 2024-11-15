package DynamicProgramming.Medium.Strings;
import java.util.Arrays;

public class JWildCardMatching {
    public static void main(String args[]) {
        String S1 = "ab*cd";
        String S2 = "abdefcd";

        if (wildcardMatching(S1, S2))
            System.out.println("String S1 and S2 do match");
        else
            System.out.println("String S1 and S2 do not match");
    }
    public static boolean wildcardMatching(String s, String p) {
        int n=s.length(),m=p.length();
        int[][] dp = new int[n][m];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return match(n-1,m-1,s,p,dp);
    }
    static boolean match(int i,int j,String s, String t, int[][] dp){
        if(i<0 && j<0)
            return true;
        if(i<0 && j>=0)
            return false;
        if(j<0 && i>=0){
            for(int i1=i;i1<=i;i1++){
                if(s.charAt(i1) != '*')
                    return false;
            }
            return true;
        }
        if(dp[i][j]!=-1)
            return dp[i][j] == 0 ? false: true;
        if(s.charAt(i) == t.charAt(j) || s.charAt(i)=='?')
        {
            boolean take = match(i-1,j-1,s,t,dp);
            dp[i][j] = take ? 1 : 0;
            return take;
        }
        else{
            if(s.charAt(i) == '*'){
                boolean notTake = (match(i-1,j,s,t,dp) || match(i,j-1,s,t,dp));
                dp[i][j] = notTake ? 1 : 0;
                return notTake;
            }
            else
                return false;
        }
    }
}
