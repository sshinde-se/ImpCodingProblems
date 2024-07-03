package DynamicProgramming1;

import java.util.HashMap;
import java.util.Map;

/*
You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.
 */
public class MinCostClimbingStairs {
    public static int minCostClimbingStairsUsingBottomUpDP(int[] cost) {
             int n = cost.length;
             int[] dp = new int[n];
             for(int i=0;i<n;i++){
                 if(i<2)
                     dp[i] = cost[i];
                 else
                     dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
             }
             return Math.min(dp[n-1],dp[n-2]);
         }
    public static int minCostClimbingStairsUsingFineTuning(int[] cost) {
        int n = cost.length;
        int first=cost[0];
        int second=cost[1];
        if(n<=2)
            return Math.min(first,second);
        for(int i=2;i<n;i++){
            int curr = cost[i] + Math.min(first, second);
            first = second;
            second = curr;
        }
        return Math.min(first, second);
    }
    public static void main(String[] args){
        int[] n = {10, 15, 20};
        int[] n1 = {1,100,1,1,1,100,1,1,100,1};


        System.out.println(minCostClimbingStairsUsingBottomUpDP(n));
        System.out.println(minCostClimbingStairsUsingFineTuning(n));

        System.out.println(minCostClimbingStairsUsingBottomUpDP(n1));
        System.out.println(minCostClimbingStairsUsingFineTuning(n1));
    }
}
