package DynamicProgramming.Medium.OneD;
/*
You are given an integer array nums where nums[i] represents the amount of money the ith house has.
The houses are arranged in a circle, i.e. the first house and the last house are neighbors.

You are planning to rob money from the houses, but you cannot rob two adjacent houses because the
security system will automatically alert the police if two adjacent houses were both broken into.

Return the maximum amount of money you can rob without alerting the police.

Input: nums = [2,9,8,3,6]

Output: 15
Explanation: You cannot rob nums[0] + nums[2] + nums[4] = 16 because nums[0] and nums[4] are adjacent houses.
The maximum you can rob is nums[1] + nums[4] = 15
 */
public class EHouseRobberII {
    public static void main(String[] args){
        int[] arr = {2,9,8,3,6};
        System.out.println("Max robbed amount using tabulation: " + maxRobbingUsingTabulation(arr));
        System.out.println("Max robbed amount using space optimization: " + maxRobUsingSpaceOptimization(arr));
    }

    private static int maxRobbingUsingTabulation(int[] arr) {
        int n = arr.length;
        // calculate amount from first index i.e 0 to last-1
        int[] dp = new int[n-1];
        dp[0] = arr[0];
        for(int i=1;i<n-1;i++){
            int pick = arr[i];
            if(i>1)
                pick += dp[i-2];
            int nonPick = dp[i-1];
            dp[i] = Math.max(pick, nonPick);
        }
        // calculate amount from second index i.e 1 to last
        int[] dp1 = new int[n];
        dp1[0] = 0;
        for(int i=1;i<n;i++){
            int pick = arr[i];
            if(i>1)
                pick += dp1[i-2];
            int nonPick = dp1[i-1];
            dp1[i] = Math.max(pick, nonPick);
        }
        return Math.max(dp[n-2], dp1[n-1]);
    }

    private static int maxRobUsingSpaceOptimization(int[] arr){
        int n=arr.length;
        int prev2=0;
        int prev = arr[0];
        for(int i=1;i<n-1;i++){
            int pick = arr[i];
            if(i>1)
                pick += prev2;
            int nonPick = prev;
            int curr = Math.max(pick, nonPick);
            prev2 = prev;
            prev = curr;
        }
        int prevv2 = 0;
        int prevv = 0;
        for(int i=1;i<n;i++){
            int pick = arr[i];
            if(i>2)
                pick += prevv2;
            int nonPick = prevv;
            int curr = Math.max(pick, nonPick);
            prevv2 = prevv;
            prevv = curr;
        }
        return Math.max(prev, prevv);
    }
}
