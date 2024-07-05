package DynamicProgramming.Medium.TwoD;

import java.util.Arrays;
/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move
either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take
to reach the bottom-right corner.
 */
public class BGridUniquePaths {
    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        int[][] dp = new int[m][n];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        // Call the countWays function and print the result
        System.out.println(countWaysMemoization(m-1, n-1, dp));
        int[][] dp1 = new int[m][n];
        for(int[] row: dp1){
            Arrays.fill(row, -1);
        }
        System.out.println(countWaysTabulation(m, n, dp1));
        System.out.println(countWaysSpaceOptimization(m, n));
    }

    private static int countWaysSpaceOptimization(int m, int n) {
        int[] prev= new int[n];
        for (int i=0;i<m;i++){
            int[] temp = new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0)
                {
                    temp[j]=1;
                    continue;
                }
                int up=0,left=0;
                if(i>0)
                    up= prev[j];
                if(j>0)
                    left = temp[j-1];
                temp[j] = up + left;
            }
            prev = temp;
        }
        return prev[n-1];
    }

    private static int countWaysTabulation(int m, int n, int[][] dp) {
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0){
                    dp[i][j] = 1;
                    continue;
                }
                int up=0,left=0;
                if(i>0)
                    up = dp[i-1][j];
                if(j>0)
                    left = dp[i][j-1];
                dp[i][j] = left + up;
            }
        }
        return dp[m-1][n-1];
    }

    private static int countWaysMemoization(int i, int j, int[][]dp) {
        if(i==0 && j==0)
            return 1;
        if(i<0 || j<0)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int up = 0;
        int left = 0;
        up = countWaysMemoization(i-1, j, dp);
        left = countWaysMemoization(i, j-1, dp);
        return dp[i][j] = up + left;
    }
}
