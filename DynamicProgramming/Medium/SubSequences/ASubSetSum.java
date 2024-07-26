package DynamicProgramming.Medium.SubSequences;

import java.util.Arrays;

/*
We are given an array ‘ARR’ with N positive integers. We need to find if there is a subset in “ARR”
with a sum equal to K. If there is, return true else return false.

Input:
N = 6
arr[] = {3, 34, 4, 12, 5, 2}
sum = 9

Output: 1 (true)
Explanation: Here there exists a subset with sum = 9, 4+3+2 = 9.
 */
public class ASubSetSum {
    public static void main(String[] args){
        int n = 6;
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum=9;
        System.out.println("Subset Sum exists: "+ subsetSumMemo(n,sum,arr));
        System.out.println("Subset Sum exists: "+ subsetSumUsingTabulation(n,sum,arr));
        System.out.println("Subset Sum exists: "+ subsetSumUsingTabulationWithSpaceOptimization(n,sum,arr));
    }

    private static boolean subsetSumUsingTabulationWithSpaceOptimization(int n, int sum, int[] arr) {
        boolean[] dp = new boolean[sum+1];
        boolean[] tmp = new boolean[sum+1];
        dp[0] =true;
        for(int i=1;i<n;i++){
            tmp[0] = true;
            for(int target=1;target<=sum;target++){
                boolean notTake = dp[target];
                boolean take = false;
                if(arr[i]<=target)
                    take = dp[target-arr[i]];
                tmp[target] = take || notTake;
            }
            dp = tmp;
        }
        return dp[sum];
    }

    private static boolean subsetSumUsingTabulation(int n, int sum, int[] arr) {
        boolean[][] dp = new boolean[n][sum+1];
        for(boolean[] row:dp){
            Arrays.fill(row,false);
        }
        if(arr[0]<=sum)
            dp[0][arr[0]] = true;
        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }
        for(int i=1;i<n;i++){
            for(int target=1;target<=sum;target++){
                boolean notTake = dp[i-1][target];
                boolean take=false;
                if(arr[i]<=target){
                    take = dp[i-1][target-arr[i]];
                }
                dp[i][target] = take || notTake;
            }
        }
        return dp[n-1][sum];
    }

    private static boolean subsetSumMemo(int n, int sum, int[] arr) {
        int[][] dp = new int[n][sum+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return subSetSum(n-1,sum,arr,dp);
    }

    private static boolean subSetSum(int n, int sum, int[] arr, int[][] dp) {
        if(sum==0)
            return true;
        if(n==0){
            return arr[n] == sum;
        }
        if(dp[n][sum]!=-1)
            return dp[n][sum] == 0 ? false : true;
        boolean notTake = subSetSum(n-1,sum,arr,dp);
        boolean take = false;
        if(arr[n]<=sum){
            take = subSetSum(n-1,sum-arr[n],arr,dp);
        }
        dp[n][sum] = take || notTake ? 1 : 0;
        return take || notTake;
    }
}
