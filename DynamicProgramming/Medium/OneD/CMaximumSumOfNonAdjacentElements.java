package DynamicProgramming.Medium.OneD;

import java.util.Arrays;

/*
Given an array of ‘N’  positive integers, we need to return the maximum sum of the subsequence such that
no two elements of the subsequence are adjacent elements in the array.

Note: A subsequence of an array is a list with elements of the array where some elements are deleted
 ( or not deleted at all) and the elements should be in the same order in the subsequence as in the array.
 */
public class CMaximumSumOfNonAdjacentElements {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 9};
        int n = arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp, -1);
        int result = maxSumMemoization(n-1, arr, dp);

        // Print the result.
        System.out.println(result);
        System.out.println(maxSumTabulation(arr, dp));
        System.out.println(maxSumSpaceOptimization(arr));
    }

    private static int maxSumMemoization(int ind, int[] arr, int[] dp) {
        if(ind<0)
            return 0;
        if(ind==0)
            return arr[ind];

        if(dp[ind]!=-1)
            return dp[ind];
        int pick = arr[ind] + maxSumMemoization(ind-2, arr, dp);
        int nonPick = maxSumMemoization(ind-1, arr, dp);
        return dp[ind] = Math.max(pick, nonPick);
    }
    private static int maxSumTabulation(int[] arr, int[] dp) {
        dp[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            int pick = arr[i];
            if(i > 1)
                pick += dp[i-2];
            int nonPick = dp[i-1];
            dp[i] = Math.max(pick, nonPick);

        }
        return dp[arr.length-1];
    }
    private static int maxSumSpaceOptimization(int[] arr) {
        int prev2= 0;
        int prev = arr[0];
        for(int i=1;i<arr.length;i++){
            int pick = arr[i];
            if(i>1)
                pick += prev2;
            int nonPick = prev;
            int curri = Math.max(pick, nonPick);
            prev2 = prev;
            prev = curri;

        }
        return prev;
    }

}
