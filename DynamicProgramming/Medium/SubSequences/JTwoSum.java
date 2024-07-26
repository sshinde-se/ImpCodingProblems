package DynamicProgramming.Medium.SubSequences;

import java.util.Arrays;

/*
You are given an integer array nums and an integer target.
You want to build an expression out of nums by adding one of the symbols '+' and '-' before each
integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them
to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3

This problem is similar to CountPartitionWithGivenDiff.java

If we think deeper, we can say that the given ‘target’ can be expressed as addition of two integers
(say S1 and S2).
S1 + S2 = target   – (i)

Now, from where will this S1 and S2 come?  If we are given the array as [a,b,c,d,e], we want to place ‘+’ or ‘-’ signs in front of every array element and then add it. One example is :
+a-b-c+d+e which can be written as (+a+d+e) + (-b-c).

Therefore, we can say that S1=(+a+d+e) and S2=(-b-c) for this example.

 If we calculate the total sum of elements of the array (say totSum), we can can say that,
S1 = totSum - S2      – (ii)

Now solving for equations (i) and (iii), we can say that
S2 = (totSum - target)/2    – (iv)
 */
public class JTwoSum {
    public static void main(String[] args){
        int[] nums = {1,1,1,1,1};
        int target = 3;

        System.out.println("Count ways to achieve target: "+ countTwoSumMemo(target,nums));
        System.out.println("Count ways to achieve target: "+ countTwoSumUsingTabulation(target,nums));
        System.out.println("Count ways to achieve target: "+ countTwoSumUsingSpaceOptimization(target,nums));
    }

    private static int countTwoSumUsingSpaceOptimization(int target, int[] nums) {
        int total=0,n=nums.length;
        for(int i:nums)
            total += i;

        if(total-target < 0)
            return 0;
        if((total-target)%2 ==1)
            return 0;
        int s2=(total-target)/2;
        int[] dp = new int[s2+1];

        if(nums[0]==0)
            dp[0] = 2;
        else
            dp[0] = 1;
        if(nums[0]!=0 && nums[0]<=s2)
            dp[nums[0]] = 1;
        for(int i=1;i<n;i++){
            int[] tmp = new int[s2+1];
            for(int s=0;s<=s2;s++){
                int notTake = dp[s];
                int take = 0;
                if(nums[i]<=s)
                    take = dp[s-nums[i]];
                tmp[s] = take+notTake;
            }
            dp=tmp;
        }
        return dp[s2];
    }

    private static int countTwoSumUsingTabulation(int target, int[] nums) {
        int total=0,n=nums.length;
        for(int i:nums)
            total += i;

        if(total-target < 0)
            return 0;
        if((total-target)%2 ==1)
            return 0;
        int s2=(total-target)/2;
        int[][] dp = new int[n][s2+1];

        if(nums[0]==0)
            dp[0][0] = 2;
        else
            dp[0][0] = 1;
        if(nums[0]!=0 && nums[0]<=s2)
            dp[0][nums[0]] = 1;

        for(int i=1;i<n;i++){
            for(int s=0;s<=s2;s++){
                int notTake = dp[i-1][s];
                int take = 0;
                if(nums[i]<=s)
                    take = dp[i-1][s-nums[i]];
                dp[i][s] = take+notTake;
            }
        }
        return dp[n-1][s2];
    }

    private static int countTwoSumMemo(int target, int[] nums) {
        int total=0,n=nums.length;
        for(int i:nums)
            total += i;

        if(total-target < 0)
            return 0;
        if((total-target)%2 ==1)
            return 0;

        int s2= (total-target)/2; //s1+s2=total, s1-s2=target, s2=(total-target)/2
        int[][] dp = new int[n][s2+1];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return countSum(n-1,s2,nums,dp);
    }
    private static int countSum(int i, int target, int[] nums, int[][] dp){
        if(i==0){
            if(target==0 && nums[0]==0)
                return 2;
            if(target==0 || nums[0]==target)
                return 1;
            return 0;
        }
        if(dp[i][target] !=-1)
            return dp[i][target];
        int notTake = countSum(i-1,target,nums,dp);
        int take=0;
        if(nums[i]<=target)
            take = countSum(i-1,target-nums[i],nums,dp);
        return dp[i][target] = take + notTake;
    }
}
