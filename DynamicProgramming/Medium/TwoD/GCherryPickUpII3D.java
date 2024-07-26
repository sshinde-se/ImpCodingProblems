package DynamicProgramming.Medium.TwoD;

import java.util.Arrays;
/*
We are given an ‘N*M’ matrix. Every cell of the matrix has some chocolates on it, mat[i][j]
gives us the number of chocolates. We have two friends ‘Alice’ and ‘Bob’. initially, Alice is standing
on the cell(0,0) and Bob is standing on the cell(0, M-1). Both of them can move only to the cells below
them in these three directions: to the bottom cell (?), to the bottom-right cell(?), or to the
bottom-left cell(?).

When Alica and Bob visit a cell, they take all the chocolates from that cell with them. It can
happen that they visit the same cell, in that case, the chocolates need to be considered only once.

They cannot go out of the boundary of the given matrix, we need to return the maximum number
of chocolates that Bob and Alice can together collect.

Approach:
We have 2 fixed points where we can start but end point is variable for this we can say row is common
for Alice and bob but column(j) can be different. for recursion we need i and j1(Alice) and j2(Bob)

So here we require 3D DP for storing i,j1,j2.

 */
public class GCherryPickUpII3D {
    public static void main(String[] args){
        int[][] matrix = {{3,1,1},
                          {2,5,1},
                          {1,5,5},
                          {2,1,1}};
        int m = matrix.length;
        int n = matrix[0].length;

        System.out.println("Min path sum from first row to Last: "+ cherryPickUpMemo(m,n,matrix));
        System.out.println("Min path sum from first row to Last: "+ cherryPickUpTabulation(m,n,matrix));
        System.out.println("Min path sum from first row to Last: "+ cherryPickUpTabulationWithSpaceOptimization(m,n,matrix));
    }

    private static int cherryPickUpTabulationWithSpaceOptimization(int m, int n, int[][] grid) {
        /* Time Complexity: O(M*N*N)*9 Reason: The outer nested loops run for (M*N*N) times and
            the inner two nested loops run for 9 times.
           Space Complexity: O(N*N) Reason: We are using an external array of size ‘N*N’.
         */
        int[][] dp = new int[n][n];
        int[][] tmp = new int[n][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        for(int j1=0;j1<n;j1++){
            for(int j2=0;j2<n;j2++){
                if(j1==j2)
                    dp[j1][j2] = grid[m-1][j1];
                else
                    dp[j1][j2] = grid[m-1][j1] + grid[m-1][j2];
            }
        }
        for(int i=m-2;i>=0;i--){
            for(int j1=0;j1<n;j1++){
                for(int j2=0; j2<n;j2++){
                    int max=Integer.MIN_VALUE;
                    //for each cell, j1 and j2 have 9 values ->left,up,right
                    for(int dj1=-1;dj1<=1;dj1++){
                        for(int dj2=-1;dj2<=1;dj2++){
                            int val=0;
                            if(j1==j2)
                                val = grid[i][j1];
                            else
                                val = grid[i][j1] + grid[i][j2];
                            if(j1+dj1<0 || j1+dj1>=n || j2+dj2<0 || j2+dj2>=n)
                                val += (int) Math.pow(-10,9);
                            else
                                val += dp[j1+dj1][j2+dj2];
                            max = Math.max(max,val);
                        }
                    }
                    tmp[j1][j2] = max;
                }
            }
            for(int a=0;a<n;a++)
                dp[a] = tmp[a].clone();
        }
        return dp[0][n-1];
    }

    private static int cherryPickUpTabulation(int m, int n, int[][] grid) {
        /* Time Complexity: O(M*N*N)*9 Reason: The outer nested loops run for (M*N*N) times and the inner two nested loops run for 9 times.
           Space Complexity: O(M*N*N) Reason: We are using an external array of size ‘M*N*N’. The stack space will be eliminated.
         */
        int[][][] dp = new int[m][n][n];
        for(int[][] row1:dp){
            for(int[] row:row1){
                Arrays.fill(row,-1);
            }
        }
        for(int j1=0;j1<n;j1++){
            for(int j2=0;j2<n;j2++){
                if(j1==j2)
                    dp[m-1][j1][j2] = grid[m-1][j1];
                else
                    dp[m-1][j1][j2] = grid[m-1][j1] + grid[m-1][j2];
            }
        }
        for(int i=m-2;i>=0;i--){
            for(int j1=0;j1<n;j1++){
                for(int j2=0;j2<n;j2++){
                    int max=Integer.MIN_VALUE;
                    for(int dj1=-1;dj1<=1;dj1++){
                        for(int dj2=-1;dj2<=1;dj2++){
                            int val=0;
                            if(j1==j2)
                                val = grid[i][j1];
                            else
                                val = grid[i][j1]+ grid[i][j2];
                            if(j1+dj1<0  || j2+dj2<0 || j1+dj1>=n || j2+dj2>=n)
                                val += (int) Math.pow(-10,9);
                            else
                                val += dp[i+1][j1+dj1][j2+dj2];
                            max = Math.max(val,max);
                        }
                    }
                    dp[i][j1][j2] = max;
                }
            }
        }
        return dp[0][0][n-1];
    }

    private static int cherryPickUpMemo(int m, int n, int[][] grid) {
        /*Time Complexity: O(M*N*N) * 9 Reason: At max, there will be M*N*N calls of recursion to solve a new problem and in every call, two nested loops together run for 9 times.
          Space Complexity: O(N) + O(M*N*N) Reason: We are using a recursion stack space: O(N), where N is the path length and an external DP Array of size ‘M*N*N’.
        */
        int[][][] dp = new int[m][n][n];
        for(int[][] row1: dp){
            for(int[] row: row1){
                Arrays.fill(row,-1);
            }
        }
        return cherryPickUp(0,0,n-1,m,n,grid,dp);
    }

    private static int cherryPickUp(int i, int j1, int j2, int m, int n, int[][] grid, int[][][] dp) {
        if(j1<0 || j2<0 || j1>=n || j2>=n)
            return (int) Math.pow(-10,9);
        if(i==m-1){
            if(j1==j2)
                return grid[i][j1];
            else
                return grid[i][j1] + grid[i][j2];
        }
        if(dp[i][j1][j2]!=-1)
            return dp[i][j1][j2];
        int max=Integer.MIN_VALUE;
        for(int dj1=-1;dj1<=1;dj1++){
            for(int dj2=-1;dj2<=1;dj2++){
                int val = 0;
                if(j1==j2)
                    val = grid[i][j1] + cherryPickUp(i+1, j1+dj1,j2+dj2,m,n,grid,dp);
                else
                    val = grid[i][j1] + grid[i][j2] + cherryPickUp(i+1,j1+dj1,j2+dj2,m,n,grid,dp);
                max = Math.max(val,max);
            }
        }
        return dp[i][j1][j2] = max;
    }
}
