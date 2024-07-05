package DynamicProgramming.Medium.OneD;

import java.util.Arrays;

/*
Given a number of stairs and a frog, the frog wants to climb from the 0th stair to the (N-1)th stair.
At a time the frog can climb either one or two steps. A height[N] array is also given. Whenever the frog
jumps from a stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]),
where abs() means the absolute difference. We need to return the minimum energy that can be used by the
frog to jump from stair 0 to stair N-1.
 */
public class AMinEnergyForFrogJump {
    public static void main(String[] args) {

        int[] height ={30,10,60 , 10 , 60 , 50};
        int n=height.length;
        int[] dp =new int[n];
        Arrays.fill(dp, -1);
        System.out.println(minEnergyMemoization(n-1,height,dp));
        System.out.println(minEnergyTabulation(height,dp));
        System.out.println(minEnergyWithSpaceOptimization(height));
    }

    private static int minEnergyMemoization(int ind, int[] height, int[] dp) {
        if(ind == 0)
            return 0;
        int jumpTwo = Integer.MAX_VALUE;
        int jumpOne = minEnergyMemoization(ind-1, height, dp) + Math.abs(height[ind] - height[ind-1]);
        if(ind > 1)
            jumpTwo = minEnergyMemoization(ind-2, height, dp) + Math.abs(height[ind] - height[ind-2]);
        return Math.min(jumpOne, jumpTwo);
    }

    private static int minEnergyTabulation(int[] height, int[] dp) {
        dp[0] = 0;
        for(int ind=1; ind< height.length; ind++){
            int jumpTwo = Integer.MAX_VALUE;
            int jumpOne = dp[ind-1] + Math.abs(height[ind] - height[ind-1]);
            if(ind > 1)
                jumpTwo = dp[ind-2] + Math.abs(height[ind] - height[ind-2]);
            dp[ind] = Math.min(jumpOne, jumpTwo);
        }
        return dp[height.length-1];
    }
    private static int minEnergyWithSpaceOptimization(int[] height) {
        int n= height.length;
        int prev2=0, prev=0;
        for(int ind=1; ind< height.length; ind++){
            int jumpTwo = Integer.MAX_VALUE;
            int jumpOne = prev + Math.abs(height[ind] - height[ind-1]);
            if(ind>1)
                jumpTwo = prev2 + Math.abs(height[ind] - height[ind-2]);
            int curri = Math.min(jumpOne, jumpTwo);
            prev2 = prev;
            prev = curri;
        }

        return prev;
    }


}
