package DynamicProgramming.Easy;

import java.util.Arrays;
//We need to find the nth Fibonacci number, where n is based on a 0-based index.
public class NthNumberInFibonacciSeries {
    public static void main(String[] args){
        int n=5;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(nthNumberInFiboSeriesMemoization(n, dp));
        System.out.println(nthNumberInFiboSeriesTabulation(n));
        System.out.println(nthNumberInFiboSeriesTabulationWithSpaceOptimization(n));
    }

    private static int nthNumberInFiboSeriesTabulationWithSpaceOptimization(int n) {
        int prev2=0, prev=1;
        int curri=0;
        for(int i=2;i<=n;i++){
            curri = prev + prev2;
            prev2 = prev;
            prev = curri;
        }
        return curri;
    }

    private static int nthNumberInFiboSeriesTabulation(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    private static int nthNumberInFiboSeriesMemoization(int n, int[] dp) {
        if(n<=1)
            return n;
        if(dp[n] != -1)
            return dp[n];
        return nthNumberInFiboSeriesMemoization(n-1, dp) + nthNumberInFiboSeriesMemoization(n-2, dp);
    }

}
