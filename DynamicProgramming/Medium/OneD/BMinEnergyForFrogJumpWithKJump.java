package DynamicProgramming.Medium.OneD;

import java.util.Arrays;

/*
Given a number of stairs and a frog, the frog wants to climb from the 0th stair to the (N-1)th stair.
the frog is allowed to jump up to ‘K’ steps at a time. If K=4, the frog can jump 1,2,3, or 4 steps at every index.
A height[N] array is also given. Whenever the frog jumps from a stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]),
where abs() means the absolute difference. We need to return the minimum energy that can be used by the
frog to jump from stair 0 to stair N-1.

https://takeuforward.org/data-structure/dynamic-programming-frog-jump-with-k-distances-dp-4/
 */
public class BMinEnergyForFrogJumpWithKJump {
    public static void main(String[] args) {

        int[] height ={30,10,60,10,60,50};
        int n=height.length;
        int[] dp =new int[n];
        Arrays.fill(dp, -1);
        int k=3;
        System.out.println(minEnergyMemoization(n-1,height,dp, k));
        System.out.println(minEnergyTabulation(height,dp, k));
    }

    private static int minEnergyMemoization(int ind, int[] height, int[] dp, int k) {
        if(ind == 0)
            return 0;
        if (dp[ind] != -1)
            return dp[ind];
        int mmSteps = Integer.MAX_VALUE;
        for(int j=1; j<=k; j++){
            if(ind-j >= 0){
                int jump = minEnergyMemoization(ind-j, height, dp, k) + Math.abs(height[ind] - height[ind-j]);
                mmSteps = Math.min(jump, mmSteps);
            }
        }
        return dp[ind] = mmSteps;
    }

    private static int minEnergyTabulation(int[] height, int[] dp, int k) {
        dp[0] = 0;
        for(int ind=1; ind< height.length; ind++){
            int mmSteps = Integer.MAX_VALUE;
            for(int j=1; j<=k; j++){
                if(ind-j >= 0){
                    int jump = dp[ind-j] + Math.abs(height[ind] - height[ind-j]);
                    mmSteps = Math.min(jump, mmSteps);
                }
            }
            dp[ind] = mmSteps;
        }
        return dp[height.length-1];
    }

}
