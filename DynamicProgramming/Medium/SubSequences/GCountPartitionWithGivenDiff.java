package DynamicProgramming.Medium.SubSequences;

import java.util.Arrays;
/*
Given an array arr, partition it into two subsets(possibly empty) such that each element must belong
to only one subset. Let the sum of the elements of these two subsets be S1 and S2.
Given a difference d, count the number of partitions in which S1 is greater than or equal to S2 and
the difference between S1 and S2 is equal to d. Since the answer may be large return it modulo 109 + 7.

n = 4
d = 0
arr[] = {1, 1, 1, 1}
Output: 6
Explanation:
we can choose two 1's from indices {0,1}, {0,2}, {0,3}, {1,2}, {1,3}, {2,3} and put them in S1 and remaning two 1's in S2.
Thus there are total 6 ways for partition the array arr.

This question is a slight modification of the problem discussed in Count Subsets with Sum K.
We have the following two conditions given to us.

S1 + S2 = D   – (i)

S1 >= S2     – (ii)

If we calculate the total sum of elements of the array (say totSum), we can say that,

S1 = totSum - S2      – (iii)

Now solving for equations (i) and (iii), we can say that

S2 = (totSum - D)/2    – (iv)

Therefore the question “Count Partitions with a difference D” is modified to “Count Number of subsets with sum (totSum - D)/2 ”.
 */
public class GCountPartitionWithGivenDiff {
    static int mod = (int) (Math.pow(10,9)+7);
    public static void main(String[] args) {

        int[] arr = {5,2,6,4};
        int d=3;

        System.out.println("The number of subsets found are: "+countPartitionsWithDiffUsingMemo(d,arr));
        System.out.println("The number of subsets found are: "+countPartitionsWithDiffUsingTabulation(d,arr));
        System.out.println("The number of subsets found are: "+countPartitionsWithDiffUsingTabulationWithSpaceOptimization(d,arr));
    }

    private static int countPartitionsWithDiffUsingTabulationWithSpaceOptimization(int d, int[] arr) {
        int sum=0,n= arr.length;
        for(int i:arr)
            sum+=i;
        if (sum-d<0)
            return 0;
        if((sum-d)%2 ==1)
            return 0;
        int target = (sum-d)/2;
        int[] dp = new int[target+1];
        if(arr[0]==0)
            dp[0] = 2;
        else
            dp[0] = 1;
        if(arr[0]!=0 && arr[0]<=target)
            dp[arr[0]] = 1;
        for(int i=1;i<n;i++){
            int[] tmp = new int[target+1];
            for(int t=0;t<=target;t++){
                int notTake = dp[t];
                int take=0;
                if(arr[i]<=t)
                    take=dp[t-arr[i]];
                tmp[t] = (take+notTake) % mod;
            }
            dp=tmp;
        }
        return dp[target];
    }

    private static int countPartitionsWithDiffUsingTabulation(int d, int[] arr) {
        int sum=0,n= arr.length;
        for(int i:arr)
            sum+=i;
        if (sum-d<0)
            return 0;
        if((sum-d)%2 ==1)
            return 0;
        int target = (sum-d)/2;
        int[][] dp = new int[n][target+1];
        if(arr[0]==0)
            dp[0][0] = 2;
        else
            dp[0][0] = 1;
        if(arr[0]!=0 && arr[0]<=target)
            dp[0][arr[0]] = 1;

        for(int i=1;i<n;i++){
            for(int t=0;t<=target;t++){
                int notTake= dp[i-1][t];
                int take = 0;
                if(arr[i]<=t)
                    take = dp[i][t-arr[i]];
                dp[i][t] = (take+notTake) % mod;
            }
        }
        return dp[n-1][target];
    }

    private static int countPartitionsWithDiffUsingMemo(int d, int[] arr) {
        int sum=0,n=arr.length;
        for(int i:arr)
            sum+=i;
        if(sum-d<0)
            return 0;
        if((sum-d)%2 == 1)
            return 0;
        int s2 = (sum-d)/2; // s1 - s2 = d and s1 + s2 = sum, s1 = sum -s2 i.e s2=(sum-d)/2
        int[][] dp =new int[n][s2+1];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return countPartitions(n-1,s2,arr,dp);
    }

    private static int countPartitions(int i, int sum, int[] arr, int[][] dp) {
        if(i==0){
            if(sum == 0 && arr[0] == 0)
                return 2;
            else if(sum == 0 || arr[0] == sum)
                return 1;
            return 0;
        }
        if(dp[i][sum]!=-1)
            return dp[i][sum];
        int notTake = countPartitions(i-1,sum,arr,dp);
        int take=0;
        if(arr[i]<=sum)
            take = countPartitions(i-1,sum-arr[i],arr,dp);
        return dp[i][sum] = (take+notTake) % mod;
    }
}
