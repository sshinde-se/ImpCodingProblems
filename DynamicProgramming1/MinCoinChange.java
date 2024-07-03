package DynamicProgramming1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//minimum coins required to collect given amount
public class MinCoinChange {
    public static void main(String[] args){
        int[] coins = {1,3,4,5};
        int amount = 7;
        System.out.println(coinChange(coins, amount));
    }

    private static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0]=0;
        for(int i=1; i<=amount; i++){
            for(int coin:coins){
                if(i-coin>=0){
                    dp[i] = Math.min(dp[i], 1+dp[i-coin]);
                }
            }
        }
        return dp[amount] != amount+1 ? dp[amount] : -1;
    }
}
