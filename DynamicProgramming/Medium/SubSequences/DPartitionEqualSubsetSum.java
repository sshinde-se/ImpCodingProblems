package DynamicProgramming.Medium.SubSequences;
import java.util.Arrays;
/*
We are given an array ‘ARR’ with N positive integers. We need to find if we can partition the array
into two subsets such that the sum of elements of each subset is equal to the other.

If we can partition, return true else return false.

We will calculate total sum and then if sum is even then only we can partition into subset sum
so its similar to SubSetSum.java with target=sum/2

 */
public class DPartitionEqualSubsetSum {
    public static void main(String[] args){
        int[] arr = {1,5,11,5};
        int n=arr.length;

        System.out.println("Partition Subset Sum exists: "+ canPartitionSubsetSumMemo(n,arr));
        System.out.println("Partition Subset Sum exists: "+ canPartitionSubsetSumUsingTabulation(n,arr));
        System.out.println("Partition Subset Sum exists: "+ canPartitionSubsetSumUsingTabulationWithSpaceOptimization(n,arr));
    }

    private static boolean canPartitionSubsetSumUsingTabulationWithSpaceOptimization(int n, int[] arr) {
        int sum=0;
        for(int i:arr){
            sum += i;
        }
        if(sum%2!=0)
            return false;
        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        if(arr[0]<=target)
            dp[arr[0]] = true;

        for(int i=1;i<n;i++){
            boolean[] tmp = new boolean[target+1];
            tmp[0] = true;
            for(int t=1;t<=target;t++){
                boolean notTake = dp[t];
                boolean take = false;
                if(arr[i]<=t)
                    take = dp[t-arr[i]];
                tmp[t] = take || notTake;
            }
            dp =tmp;
        }
        return dp[target];
    }

    private static boolean canPartitionSubsetSumUsingTabulation(int n, int[] arr) {
        int sum=0;
        for(int i:arr){
            sum += i;
        }
        if(sum%2!=0)
            return false;
        int target = sum/2;
        boolean[][] dp = new boolean[n][target+1];
        for(int i=0;i<n;i++)
            dp[i][0] = true;
        if(arr[0]<=target)
            dp[0][arr[0]] = true;
        for(int i=1;i<n;i++){
            for(int t=1;t<=target;t++){
                boolean notTake = dp[i-1][t];
                boolean take = false;
                if(arr[i]<=t)
                    take = dp[i-1][t-arr[i]];
                dp[i][t] = take || notTake;
            }
        }
        return dp[n-1][target];
    }

    private static boolean canPartitionSubsetSumMemo(int n, int[] arr) {
        int sum=0;
        for(int i:arr){
            sum += i;
        }
        if(sum%2!=0)
            return false;
        int target = sum/2;
        int[][] dp = new int[n][target+1];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return canPartition(n-1,target,arr,dp);
    }

    private static boolean canPartition(int i, int target, int[] arr, int[][] dp) {
        if(target==0)
            return true;
        if(i==0)
            return arr[0] == target;
        if(dp[i][target] !=-1)
            return dp[i][target] == 0 ? false : true;
        boolean notTake = canPartition(i-1,target,arr,dp);
        boolean take = false;
        if(arr[i]<=target)
            take = canPartition(i-1,target-arr[i],arr,dp);
        dp[i][target] = take || notTake ? 1 : 0;
        return take || notTake;
    }
}
