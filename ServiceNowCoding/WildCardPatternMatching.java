package ServiceNowCoding;

/*
Text = "baaabab",
Pattern = “*****ba*****ab", output : true
Pattern = "baaa?ab", output : true
Pattern = "ba*a?", output : true
Pattern = "a*ab", output : false
 */
public class WildCardPatternMatching {
    public static void main(String[] main){
        String pattern = "ab*cd";
        String text = "abdefcd";
        int n=pattern.length();
        int m=text.length();
        //System.out.println(wildCardMatching(n-1, m-1, pattern, text));
        System.out.println(wildCardMatchingIteration(pattern, text));

        String pattern1 = "a*ab";
        String text1 = "baaabab";
        int n1=pattern.length();
        int m1=text.length();
        //System.out.println(wildCardMatching(n1-1, m1-1, pattern1, text1));
        System.out.println(wildCardMatchingIteration(pattern1, text1));
    }

    private static boolean wildCardMatchingIteration(String pattern, String text) {
        int n=pattern.length();
        int m=text.length();
        boolean[][] dp =new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int j=1; j<=m; j++){
            dp[0][j] = false;
        }
        for(int i=1; i<=n; i++){
            dp[i][0] = isAllStars(pattern, i);
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(pattern.charAt(i-1) == text.charAt(j-1) || pattern.charAt(i-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    if(pattern.charAt(i-1) == '*'){
                        dp[i][j] = dp[i-1][j] || dp[i][j-1];
                    }
                    else
                        dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }

    private static boolean isAllStars(String pattern, int i) {
        for(int j=1; j<=i; j++){
            if(pattern.charAt(j-1) != '*')
                return false;
        }
        return true;
    }

    private static boolean wildCardMatching(int i, int j, String pattern, String text) {
        if(i<0 && j<0)
            return true;
        if(i<0 && j>=0)
            return false;
        if(j<0 && i>=0){
            for(int ii=0; ii<i; ii++){
                if(pattern.charAt(ii) != '*')
                    return false;
            }
            return true;
        }
        if(pattern.charAt(i) == text.charAt(j) || pattern.charAt(i) == '?')
            return wildCardMatching(i-1, j-1, pattern, text);
        if(pattern.charAt(i) == '*'){
            return wildCardMatching(i-1, j, pattern, text) || wildCardMatching(i, j-1, pattern, text);
        }
        return false;
    }
}
