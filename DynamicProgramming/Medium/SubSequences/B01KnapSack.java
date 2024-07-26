package DynamicProgramming.Medium.SubSequences;

import java.util.Arrays;

/*
You are given weights and values of N items, put these items in a knapsack of capacity W to get the
maximum total value in the knapsack. Note that we have only one quantity of each item.
In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights
associated with N items respectively. Also given an integer W which represents knapsack capacity, find
out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or
equal to W. You cannot break an item, either pick the complete item or dont pick it (0-1 property).
https://takeuforward.org/data-structure/0-1-knapsack-dp-19/

Input:
N = 3
W = 4
values[] = {1,2,3}
weight[] = {4,5,1}
Output: 3
Explanation: Choose the last item that weighs 1 unit and holds a value of 3.
 */
public class B01KnapSack {
    public static void main(String[] args){
        int n=3;
        int W=6;
        int[] wt = {3,2,5};
        int[] val = {30,40,60};

        System.out.println("Max val thief can take: "+ maxValueUsingMemo(n,W,wt,val));
        System.out.println("Max val thief can take: "+ maxValueUsingTabulation(n,W,wt,val));
        System.out.println("Max val thief can take: "+ maxValueUsingTabulationSpaceOptimization(n,W,wt,val));
    }

    private static int maxValueUsingTabulationSpaceOptimization(int n, int W, int[] wt, int[] val) {
        int[] dp = new int[W+1];
        int[] tmp = new int[W+1];
        for(int i=wt[0];i<=W;i++){
            dp[i] = val[0];
        }
        for(int i=1;i<n;i++){
            for(int w=0;w<=W;w++){
                int notPick = dp[w];
                int pick = Integer.MIN_VALUE;
                if(wt[i]<=w)
                    pick = val[i] + dp[w-wt[i]];
                tmp[w] = Math.max(pick,notPick);
            }
            dp = tmp;
        }
        return dp[W];
    }

    private static int maxValueUsingTabulation(int n, int W, int[] wt, int[] val) {
        //declaring dp with n for input array and W+1 for capacity as capacity can take any value between ‘0’ and ‘W’.
        int[][] dp=new int[n][W+1];
        /* At ind==0, we are considering the first element, if the capacity of the knapsack is greater
        than the weight of the first item, we return val[0] as answer. We will achieve this using a
        for loop. */
        for(int i=wt[0];i<=W;i++){
            dp[0][i] = val[0];
        }
        for(int i=1;i<n;i++){
            for(int w=0;w<=W;w++){
                int notPick = dp[i-1][w];
                int pick = (int) Math.pow(-10,9);
                if(wt[i]<=w)
                    pick = val[i] + dp[i-1][w-wt[i]];
                dp[i][w] = Math.max(pick,notPick);
            }
        }
        return dp[n-1][W];
    }

    private static int maxValueUsingMemo(int n, int W, int[] wt, int[] val) {
        //declaring dp with n for input array and W+1 for capacity as capacity can take any value between ‘0’ and ‘W’.
        int[][] dp = new int[n][W+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return maxValue(n-1,W,wt,val,dp);
    }
    private static int maxValue(int i,int W, int[] wt, int[] val, int[][] dp){
        if(i==0)
            return wt[0]<=W ? val[0] : 0;
        if(dp[i][W]!=-1)
            return dp[i][W];
        int notPick = maxValue(i-1,W,wt,val,dp);
        int pick = (int) Math.pow(-10,9);
        if(wt[i]<=W)
            pick = val[i] + maxValue(i-1,W-wt[i],wt,val,dp);
        return dp[i][W] = Math.max(pick,notPick);
    }
}
