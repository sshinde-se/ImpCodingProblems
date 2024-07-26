package DynamicProgramming.Medium.TwoD;

import java.util.Arrays;
public class DFindMinPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1},
                        {1, 5, 1},
                        {4, 2, 1}};

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        System.out.println("Find min path sum Memo: "+ findMinPathSumMemo(m-1, n-1, grid,dp)); /*
        Time Complexity: O(N*M)
        Reason: At max, there will be N*M calls of recursion.
        Space Complexity: O((M-1)+(N-1)) + O(N*M)
        Reason: We are using a recursion stack space: O((M-1)+(N-1)), here (M-1)+(N-1) is the path length and an external DP Array of size ‘N*M’.
        */
        System.out.println("Find min path sum Memo: "+ findMinPathSumTabulation(m-1, n-1, grid,dp));
        /*
        Time Complexity: O(N*M) Reason: There are two nested loops
        Space Complexity: O(N*M) Reason: We are using an external array of size ‘N*M’’.
         */
        System.out.println("Find min path sum Memo: "+ findMinPathSumSpaceOptimization(m-1, n-1, grid));
        /*
        Time Complexity: O(M*N) Reason: There are two nested loops
        Space Complexity: O(N) Reason: We are using an external array of size ‘N’ to store only one row.
         */
    }

    private static int findMinPathSumSpaceOptimization(int m, int n, int[][] grid) {
        int[] dp =new int[n];
        for(int i=0;i<m;i++){
            int[] tmp=new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    tmp[j] = grid[0][0];
                    continue;
                }
                int up=grid[i][j], left=grid[i][j];
                if(i>0)
                    up = up + dp[j];
                else
                    up = Integer.MAX_VALUE;
                if(j>0)
                    left = left + tmp[j-1];
                else
                    left = Integer.MAX_VALUE;
                tmp[j] = Math.min(up,left);
            }
            dp = tmp;
        }
        return dp[n-1];
    }

    private static int findMinPathSumTabulation(int m, int n, int[][] grid, int[][] dp) {
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    dp[i][j] = grid[i][j];
                    continue;
                }
                int up=Integer.MAX_VALUE, left=Integer.MAX_VALUE;
                if(i>0)
                    up = grid[i][j] + dp[i-1][j];
                if(j>0)
                    left = grid[i][j] + dp[i][j-1];
                dp[i][j] = Math.min(up,left);
            }
        }
        return dp[m-1][n-1];
    }

    private static int findMinPathSumMemo(int i,int j,int[][] grid, int[][] dp) {
        if(i==0 && j==0)
            return grid[0][0];
        if(i<0 || j<0)
            return (int) Math.pow(10,9);
        int up = grid[i][j] + findMinPathSumMemo(i-1,j,grid,dp);
        int left = grid[i][j] + findMinPathSumMemo(i,j-1, grid,dp);
        return dp[i][j] = Math.min(up,left);
    }

}
