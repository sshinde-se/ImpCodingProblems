package DynamicProgramming.Medium.SubSequences;
import java.util.Arrays;
/*
You are given an integer array coins representing coins of different denominations and an integer
amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money
cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
 */
public class HMinCoinsRequiredToCollectAmount {
    public static void main(String[] args){
        int[] coins = {1,2,5};
        int amount = 11;

        System.out.println("Collect min coins using memo: "+minCoinsForAmountMemo(coins,amount));
        System.out.println("Collect min coins using memo: "+minCoinsForAmountUsingTabulation(coins,amount));
        System.out.println("Collect min coins using memo: "+minCoinsForAmountUsingSpaceOptimization(coins,amount));
    }

    private static int minCoinsForAmountUsingSpaceOptimization(int[] coins, int amount) {
        int n=coins.length;
        int[] dp = new int[amount+1];
        for(int a=0;a<=amount;a++){
            if(a % coins[0] == 0)
                dp[a] = a / coins[0];
            else
                dp[a] = Integer.MAX_VALUE;
        }
        for(int i=1;i<n;i++){
            int[] tmp = new int[amount+1];
            for(int a=0;a<=amount;a++){
                int notTake= dp[a];
                int take =Integer.MAX_VALUE;
                if(coins[i]<=a)
                    take = 1 + tmp[a-coins[i]]; // imp step need to take tmp as we are not prev array
                tmp[a] = Math.min(take,notTake);
            }
            dp=tmp;
        }
        return dp[amount];
    }

    private static int minCoinsForAmountUsingTabulation(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp = new int[n][amount+1];
        for(int a=0;a<=amount;a++){
            if(a % coins[0] == 0)
                dp[0][a] = a / coins[0];
            else
                dp[0][a] = Integer.MAX_VALUE;
        }
        for(int i=1;i<n;i++){
            for(int a=0;a<=amount;a++){
                int notTake = dp[i-1][a];
                int take = Integer.MAX_VALUE;
                if(coins[i]<=a)
                    take = 1 + dp[i][a-coins[i]];
                dp[i][a] = Math.min(take,notTake);
            }
        }
        return dp[n-1][amount];
    }

    private static int minCoinsForAmountMemo(int[] coins, int amount) {
        /* Time Complexity: O(N*T) Reason: There are N*T states therefore at max ‘N*T’ new problems will be solved.
           Space Complexity: O(N*T) + O(N) Reason: We are using a recursion stack space(O(N)) and a 2D array ( O(N*T)).
         */
        int n=coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        int ans = minCoins(n-1,amount,coins,dp);
        if(ans >= (int) Math.pow(10,9))
            return -1;
        return ans;
    }

    private static int minCoins(int i, int amount, int[] coins, int[][] dp) {
        if(i==0)
        {
            if(amount % coins[0] == 0)
                return amount / coins[0];// i==0 and amount=6 and coins[0] = 2 then 6/2=3 coins required
            return (int) Math.pow(10,9);
        }
        if(dp[i][amount]!=-1)
            return dp[i][amount];
        int notTake = minCoins(i-1,amount,coins,dp);
        int take = (int) Math.pow(10,9);
        if(coins[i]<=amount)
            take = 1 + minCoins(i,amount-coins[i],coins,dp); // we can take coin infinite times
        return dp[i][amount] = Math.min(take,notTake);
    }
}
