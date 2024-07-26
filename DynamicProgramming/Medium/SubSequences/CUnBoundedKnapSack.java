package DynamicProgramming.Medium.SubSequences;

import java.util.Arrays;

public class CUnBoundedKnapSack {
    public static void main(String[] args){
        int n=3;
        int W=10;
        int[] wt = {2,4,6};
        int[] val = {5,11,13};

        System.out.println("Max val thief can take: "+ maxValueWithDuplicatesUsingMemo(n,W,wt,val));
        System.out.println("Max val thief can take: "+ maxValueWithDuplicatesUsingTabulation(n,W,wt,val));
        System.out.println("Max val thief can take: "+ maxValueWithDuplicatesUsingTabulationSpaceOptimization(n,W,wt,val));
    }

    private static int maxValueWithDuplicatesUsingTabulationSpaceOptimization(int n, int W, int[] wt, int[] val) {
        int[] dp = new int[W+1];
        int[] tmp = new int[W+1];
        for(int w=0;w<=W;w++)
            dp[w] = (w/wt[0]) * val[0];
        for(int i=1;i<n;i++){
            for(int w=0;w<=W;w++){
                int notPick = dp[w];
                int pick = Integer.MIN_VALUE;
                if(wt[i]<=w)
                    pick = val[i] + tmp[w-wt[i]];
                tmp[w] = Math.max(pick,notPick);
            }
            dp = tmp;
        }
        return dp[W];
    }

    private static int maxValueWithDuplicatesUsingTabulation(int n, int W, int[] wt, int[] val) {
        int[][] dp = new int[n][W+1];
        for(int w=0;w<=W;w++){
            dp[0][w] = (w/wt[0]) * val[0];
        }
        for(int i=1;i<n;i++){
            for(int w=0;w<=W;w++){
                int notPick = dp[i-1][w];
                int pick = Integer.MIN_VALUE;
                if(wt[i]<=w)
                    pick = val[i] + dp[i][w-wt[i]];
                dp[i][w] = Math.max(pick,notPick);
            }
        }
        return dp[n-1][W];
    }

    private static int maxValueWithDuplicatesUsingMemo(int n, int W, int[] wt, int[] val) {
        int[][] dp = new int[n][W+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return maxValueWithDuplicates(n-1,W,wt,val,dp);
    }

    private static int maxValueWithDuplicates(int i, int W, int[] wt, int[] val, int[][] dp) {
        if(i==0)
            return (W/wt[i]) * val[0];
        if(dp[i][W]!=-1)
            return dp[i][W];
        int notPick = maxValueWithDuplicates(i-1,W,wt,val,dp);
        int pick = (int) Math.pow(-10,9);
        if(wt[i]<=W)
            pick = val[i] + maxValueWithDuplicates(i,W-wt[i],wt,val,dp);
        return dp[i][W] = Math.max(pick,notPick);
    }
}
