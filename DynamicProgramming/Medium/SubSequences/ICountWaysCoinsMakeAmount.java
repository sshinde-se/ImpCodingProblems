package DynamicProgramming.Medium.SubSequences;
import java.util.Arrays;
/*
You are given an integer array coins representing coins of different denominations and an integer
amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made
up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.
Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

If we need to find count then base case should return 0 or 1
 */
public class ICountWaysCoinsMakeAmount {
    public static void main(String[] args){
        int[] coins = {1,2,5};
        int amount = 5;

        System.out.println("number of combinations that make up that amount: "+countWaysToMakeAmountMemo(coins,amount));
        System.out.println("number of combinations that make up that amount: "+countWaysToMakeAmountUsingTabulation(coins,amount));
        System.out.println("number of combinations that make up that amount: "+countWaysToMakeAmountUsingSpaceOptimization(coins,amount));
    }

    private static int countWaysToMakeAmountUsingSpaceOptimization(int[] coins, int amount) {
        int n=coins.length;
        int[] dp = new int[amount+1];
        for(int a=0;a<=amount;a++){
            if(a % coins[0] == 0)
                dp[a] = 1;
        }
        for(int i=1;i<n;i++){
            int[] tmp = new int[amount+1];
            for(int a=0;a<=amount;a++){
                int notTake = dp[a];
                int take = 0;
                if(coins[i]<=a)
                    take = tmp[a-coins[i]]; //imp step
                tmp[a] = take + notTake;
            }
            dp = tmp;
        }
        return dp[amount];
    }

    private static int countWaysToMakeAmountUsingTabulation(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp = new int[n][amount+1];
        for(int a=0;a<=amount;a++){
            if(a % coins[0] == 0)
                dp[0][a] = 1;
        }
        for(int i=1;i<n;i++){
            for(int a=0;a<=amount;a++){
                int notTake = dp[i-1][a];
                int take = 0;
                if(coins[i]<=a)
                    take = dp[i][a-coins[i]];
                dp[i][a] = take + notTake;
            }
        }
        return dp[n-1][amount];
    }

    private static int countWaysToMakeAmountMemo(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return countChange(n-1,amount,coins,dp);
    }

    private static int countChange(int i, int amount, int[] coins, int[][] dp) {
        if(i==0)
        {
            if(amount % coins[0] == 0)
                return 1;
            else
                return 0;
        }
        if(dp[i][amount]!=-1)
            return dp[i][amount];
        int notTake = countChange(i-1,amount,coins,dp);
        int take = 0;
        if(coins[i]<=amount)
            take = countChange(i,amount-coins[i],coins,dp);
        return dp[i][amount] = take + notTake;
    }
}
