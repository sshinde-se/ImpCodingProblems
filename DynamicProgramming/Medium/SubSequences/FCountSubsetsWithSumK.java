package DynamicProgramming.Medium.SubSequences;

import java.util.Arrays;
/*
If we need to find count then base case should return 0 or 1
 */
public class FCountSubsetsWithSumK {
    static int mod = (int) (Math.pow(10,9)+7);
    public static void main(String[] args){
        int[] arr = {0,0,1};
        int k = 1;
        int[] arr1 = {5,2,3,10,6,8};
        int k1= 10;
        System.out.println(countSubsetsWithSumKUsingMemo(k,arr));
        System.out.println(countSubsetsWithSumKUsingTabulation(k,arr));
        System.out.println(countSubsetsWithSumKUsingSpaceOptimization(k,arr));
        System.out.println(countSubsetsWithSumKUsingMemo(k1,arr1));
        System.out.println(countSubsetsWithSumKUsingTabulation(k1,arr1));
        System.out.println(countSubsetsWithSumKUsingSpaceOptimization(k1,arr1));
    }

    private static int countSubsetsWithSumKUsingSpaceOptimization(int k, int[] arr) {
        int n=arr.length;
        int[] dp = new int[k+1];
        if(arr[0]==0)
            dp[0] = 2;
        else
            dp[0] = 1;

        if(arr[0]!=0 && arr[0]<=k)
            dp[arr[0]] = 1;
        for(int i=1;i<n;i++){
            int[] tmp = new int[k+1];
            for(int t=0;t<=k;t++){
                int notTake = dp[t];
                int take=0;
                if(arr[i]<=t)
                    take = dp[t-arr[i]];
                tmp[t] = (take + notTake) % mod;
            }
            dp = tmp;
        }
        return dp[k];
    }

    private static int countSubsetsWithSumKUsingTabulation(int k, int[] arr) {
        int n=arr.length;
        int[][] dp =new int[n][k+1];
        if(arr[0]==0)
            dp[0][0] = 2;
        else
            dp[0][0] = 1;
        if(arr[0]!=0 && arr[0]<=k)
            dp[0][arr[0]] = 1;

        for(int i=1;i<n;i++) {
            for (int t = 0; t <= k; t++) {
                int notTake = dp[i - 1][t];
                int take = 0;
                if (arr[i] <= t)
                    take = dp[i - 1][t - arr[i]];
                dp[i][t] = (take + notTake) % mod;
            }
        }
        return dp[n-1][k];
    }

    private static int countSubsetsWithSumKUsingMemo(int sum, int[] arr) {
        int n=arr.length;
        int[][] dp =new int[n][sum+1];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return countSum(n-1,sum,arr,dp);
    }

    private static int countSum(int i, int sum, int[] arr, int[][] dp) {
        if(i==0){
            if(sum==0 && arr[0]==0)
                return 2;
            else if(arr[0] == sum || sum==0)
                return 1;
            return 0;
        }
        if(dp[i][sum]!=-1)
            return dp[i][sum];
        int notTake = countSum(i-1,sum, arr,dp);
        int take =0;
        if(arr[i]<=sum)
            take = countSum(i-1,sum-arr[i],arr,dp);
        return dp[i][sum] = (take + notTake) % mod; //For large integers dividing by max int
    }
}
