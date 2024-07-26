package DynamicProgramming.Medium.TwoD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Input :
2
3 4
6 5 7
4 1 8 3

Find Min path sum from top to bottom we can only move down or digonally like from 2 we can go to 3 or 4
We cannot solve this using greedy, so we can solve it using recursion like finding all paths from top to bottom
and then finding min out of all paths.

Recursion with memo:
we start with f(0,0) as we have 4 values(4,1,8,3) at last

 */
public class EFindMinPathSumInTriangle {
    public static void main(String[] args){
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(2));
        list.add(Arrays.asList(3,4));
        list.add(Arrays.asList(6,5,7));
        list.add(Arrays.asList(4,1,8,3));

        int n=list.size();
        int[][] dp = new int[n][n];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        System.out.println("Min sum in Triangle using memo: "+ minPathSumUsingMemo(0,0,list,dp,n));
        System.out.println("Min sum in Triangle using memo: "+ minPathSumUsingTabulation(list,dp,n));
        System.out.println("Min sum in Triangle using memo: "+ minPathSumUsingTabulationWithSpaceOptimization(list,n));
    }

    private static int minPathSumUsingTabulationWithSpaceOptimization(List<List<Integer>> list, int n) {
        int[] dp = new int[n];
        for(int j=0;j<n;j++)
            dp[j] = list.get(n-1).get(j);
        for(int i=n-2;i>=0;i--){
            int[] tmp = new int[n];
            for(int j=i;j>=0;j--){
                tmp[j] = list.get(i).get(j) + Math.min(dp[j],dp[j+1]);
            }
            dp = tmp;
        }
        return dp[0];
    }

    private static int minPathSumUsingTabulation(List<List<Integer>> list, int[][] dp, int n) {
        for(int j=0;j<n;j++)
            dp[n-1][j] = list.get(n-1).get(j);
        for(int i=n-2;i>=0;i--){
            for (int j=i;j>=0;j--){
                dp[i][j] = list.get(i).get(j) + Math.min(dp[i+1][j] , dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }

    private static int minPathSumUsingMemo(int i,int j,List<List<Integer>> list,int[][] dp, int n) {
        if(i==n-1)
            return list.get(n-1).get(j);
        if(dp[i][j] != -1)
            return dp[i][j];
        int down = list.get(i).get(j) + minPathSumUsingMemo(i+1,j,list,dp,n);
        int diagonal = list.get(i).get(j) + minPathSumUsingMemo(i+1,j+1,list,dp,n);
        return dp[i][j] = Math.min(down,diagonal);
    }
}
