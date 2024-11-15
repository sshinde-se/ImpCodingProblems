package DynamicProgramming.Medium.LIS;

import java.util.Arrays;

/*
The longest increasing subsequence is described as a subsequence of an array where:

All elements of the subsequence are in increasing order.
This subsequence itself is of the longest length possible.

Intuition for Recursive Logic

At every index, we have two choices based on the pick/non-pick technique
1. Do not consider the current element in the subsequence: In this case, we are not considering
   the current element in the subsequence, therefore the length of the subsequence will not increase
   and the prev_index element will remain as it is. Hence we will return 0 + f(ind+1,prev_index) as
   our answer.
2. Consider the current element in the subsequence: In this case, we are considering the current
   element in the subsequence, therefore the length of the subsequence will increase by 1 and
   the prev_index element will be updated to the current index element.. Hence we will return 1 +
   f(ind+1,ind) as our answer. Here is a simple catch, when we want to consider the current index
   element to the subsequence, we need to check that it is greater than the last element of the
   subsequence so far,i.e the prev_index element.

   f(ind, prev_index){
        notTake = 0 + f(ind + 1, prev_index)

        if(prev_index == -1 || arr[ind]>arr[prev_index]){
            take = 1 + f(ind + 1, ind)
        }
    }
 */
public class ALongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};

        int n = arr.length;

        System.out.println("Length of the longest increasing subsequence is " + longestIncreasingSubsequenceMemo(arr, n));
        System.out.println("Length of the longest increasing subsequence is " + longestIncreasingSubsequenceSpaceOptimization(arr, n));
    }

    public static int longestIncreasingSubsequenceSpaceOptimization(int[] nums,int n) {

        int[] subsequenceLengths = new int[n];
        subsequenceLengths[0] = 1;
        int maxLengthFound = 1;

        for (int curIdx = 1; curIdx < n; curIdx++) {
            int curMax = 0;
            for (int prevIdx = curIdx - 1; prevIdx >= 0; prevIdx--) {
                if (nums[prevIdx] < nums[curIdx]) {
                    curMax = Math.max(subsequenceLengths[prevIdx], curMax);
                }
            }
            subsequenceLengths[curIdx] = curMax + 1;
            maxLengthFound = Math.max(subsequenceLengths[curIdx], maxLengthFound);
        }
        return maxLengthFound;
    }
    private static int longestIncreasingSubsequenceMemo(int[] arr, int n) {
        int[][] dp = new int[n][n];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return LIS(0,-1,arr,dp,n);
    }

    private static int LIS(int ind, int prevInd, int[] arr, int[][] dp, int n) {
        if(ind==n)
            return 0;
        if(dp[ind][prevInd+1]!=-1)
            return dp[ind][prevInd+1];
        int notTake = LIS(ind+1, prevInd, arr,dp,n);
        int take = (int) Math.pow(-10,9);
        if(prevInd == -1 || arr[ind] > arr[prevInd])
            take = 1+ LIS(ind+1, ind,arr,dp,n);
        return dp[ind][prevInd+1] = Math.max(take,notTake);
    }
}
