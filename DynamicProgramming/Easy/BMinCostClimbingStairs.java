package DynamicProgramming.Easy;

import java.util.Arrays;
import java.util.Map;

public class BMinCostClimbingStairs {
    public static void main(String[] args){
        int[] cost = {10,15,20};
        System.out.println("Min cost: "+ minCostUsingDP(cost));
        System.out.println("Min cost space optimization: "+ minCostUsingSpaceOptimization(cost));
    }

    private static int minCostUsingDP(int[] cost) {
        int n=cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        for(int i=0;i<n;i++){
            if(i<2)
                dp[i] = cost[i];
            else
                dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[n-1], dp[n-2]);
    }
    private static int minCostUsingSpaceOptimization(int[] cost){
        int prev2=cost[0];
        int prev=cost[1];
        int n=cost.length;
        if(n<=2){
            return Math.min(prev2, prev);
        }
        for(int i=2;i<n;i++){
            int curr = cost[i] + Math.min(prev2,prev);
            prev2 = prev;
            prev = curr;
        }
        return Math.min(prev2,prev);
    }
}
