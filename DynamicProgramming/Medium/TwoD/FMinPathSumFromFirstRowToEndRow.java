package DynamicProgramming.Medium.TwoD;

import java.util.Arrays;
/*
We are given an ‘N*M’ matrix. We need to find the maximum path sum from any cell of the first row
to any cell of the last row.

At every cell we can move in three directions: to the bottom cell (?),
to the bottom-right cell(?), or to the bottom-left cell(?).

So here starting and ending points may vary with different cases i.e not having
fixed starting point and ending point given in DFindMinPathSum.java problem

And for recursion it uses 3 ways for each cell hence 3^n times will iterate.
So used memoization,tabulation,space optimization approach to solve with better complexity
 */
public class FMinPathSumFromFirstRowToEndRow {
    public static void main(String[] args){
        int[][] matrix = {{2,1,3},
                          {6,5,4},
                          {7,8,9}};
        int m = matrix.length;
        int n = matrix[0].length;

        System.out.println("Min path sum from first row to Last: "+ minPathSumMemo(m,n,matrix));
        System.out.println("Min path sum from first row to Last: "+ minPathSumTabulation(m,n,matrix));
        System.out.println("Min path sum from first row to Last: "+ minPathSumTabulationWithSpaceOptimization(m,n,matrix));
    }

    private static int minPathSumTabulationWithSpaceOptimization(int m, int n, int[][] matrix) {
        /* Time Complexity: O(N*M) Reason: There are two nested loops
           Space Complexity: O(M)
           Reason: We are using an external array of size ‘M’ to store only one row.*/
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        dp = matrix[0];
        for(int i=1;i<m;i++){
            int[] tmp = new int[n];
            for(int j=0;j<n;j++){
                int up = matrix[i][j] + dp[j];
                int ld=Integer.MAX_VALUE,rd=Integer.MAX_VALUE;
                if(j>0)
                    ld = matrix[i][j] + dp[j-1];
                if(j<n-1)
                    rd = matrix[i][j] + dp[j+1];
                tmp[j] = Math.min(up, Math.min(ld,rd));
            }
            dp = tmp;
        }
        int min = dp[0];
        for(int j=1;j<n;j++)
            min = Math.min(min,dp[j]);
        return min;
    }

    private static int minPathSumTabulation(int m, int n, int[][] matrix) {
        /* Time Complexity: O(N*M) Reason: There are two nested loops
        Space Complexity: O(N*M)
        Reason: We are using an external array of size ‘N*M’. The stack space will be eliminated.*/
        int[][] dp = new int[m][n];

        //For tabulation base case will be dp[0][j]
        for(int j=0;j<n;j++){
            dp[0][j] = matrix[0][j];
        }
        //starts with next row i.e 2nd row
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                int up = matrix[i][j] + dp[i-1][j];
                int ld=Integer.MAX_VALUE,rd=Integer.MAX_VALUE;
                if(j>0)
                    ld = matrix[i][j] + dp[i-1][j-1];
                if(j<n-1)
                    rd = matrix[i][j] + dp[i-1][j+1];
                dp[i][j] = Math.min(up, Math.min(ld,rd));
            }
        }
        int min = dp[m-1][0];
        for(int j=1;j<n;j++){
            min = Math.min(min, dp[m-1][j]);
        }
        return min;
    }

    private static int minPathSumMemo(int m, int n, int[][] matrix) {
        int[][] dp = new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int min = Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            int ans = minPathSum(m-1,j,matrix,dp,n);
            min = Math.min(ans,min);
        }
        return min;
    }
    private static int minPathSum(int i,int j, int[][] matrix, int[][] dp, int n){
        /* Time Complexity: O(N*N) Reason: At max, there will be M*N calls of recursion to solve a new problem,
        Space Complexity: O(N) + O(N*M)
        Reason: We are using a recursion stack space: O(N), where N is the path length and an external DP Array of size ‘N*M’ */
        if(j<0 || j>=n)
            return (int) Math.pow(10,9);
        if(i==0)
            return matrix[0][j];
        if(dp[i][j]!=-1)
            return dp[i][j];
        int up = matrix[i][j] + minPathSum(i-1,j,matrix,dp,n);
        int ld = matrix[i][j] + minPathSum(i-1,j-1,matrix,dp,n);
        int rd = matrix[i][j] + minPathSum(i-1,j+1,matrix,dp,n);
        return dp[i][j] = Math.min(up, Math.min(ld,rd));
    }
}
