package DynamicProgramming.Medium.TwoD;

import java.util.Arrays;

public class CGridUniquePathsMazeObstacles {
    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        int n = maze.length;
        int m = maze[0].length;

        // Calculate and print the number of paths through the maze
        System.out.println(uniquePathsWithObstaclesSpaceOptimization(maze));//Time Complexity:O(M*N), Space: O(N)
        System.out.println(uniquePathsWithObstaclesTabulation(n,m,maze));//Time Complexity:O(M*N), Space: O(M*N)
        int[][] dp=new int[n][m];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        System.out.println(mazeObstaclesMemoization(n-1, m-1, maze,dp));//Time Complexity:O(M*N), Space: O(M*N)
    }

    private static int uniquePathsWithObstaclesTabulation(int m,int n,int[][] maze) {
        int[][] dp = new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        if(maze[m-1][n-1] == 1)
            return 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int up=0,left=0;
                if(i==0 && j==0){
                    dp[i][j] = 1;
                    continue;
                }
                if(i>0){
                    if(maze[i][j]==0)
                        up = dp[i-1][j];
                }
                if(j>0){
                    if(maze[i][j]==0)
                        left = dp[i][j-1];
                }
                dp[i][j] = up + left;
            }
        }
        return dp[m-1][n-1];
    }

    private static int mazeObstaclesMemoization(int i, int j, int[][] maze, int[][] dp) {
        if(i>0 && j>0 && maze[i][j]==1)
            return 0;
        if(i==0 && j==0)
            return 1;
        if(i<0 || j<0)
            return 0;
        int up = mazeObstaclesMemoization(i-1, j, maze, dp);
        int left = mazeObstaclesMemoization(i,j-1, maze, dp);
        return dp[i][j] = up+left;
    }

    public static int uniquePathsWithObstaclesSpaceOptimization(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[] prev = new int[n];
        for(int i=0;i<m;i++){
            int[] temp = new int[n];
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1)
                {
                    temp[j] = 0;
                    continue;
                }
                if(i==0&&j==0){
                    temp[j]=1;
                    continue;
                }
                int up=0,left=0;
                if(i>0)
                    up=prev[j];
                if(j>0)
                    left=temp[j-1];
                temp[j] = up+left;
            }
            prev=temp;
        }
        return prev[n-1];
    }
}
