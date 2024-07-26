package DynamicProgramming.Medium.SubSequences;
import java.util.Arrays;
public class EPartitionInto2SubsetWithMinDiff {
    public static void main(String[] args){
        int[] arr={1,2,3,4};
        int n=arr.length;
        int[] arr1={8,6,5};
        int n1=arr1.length;

        System.out.println(minDiffIn2SubsetUsingTabulation(n,arr));
        System.out.println(minDiffIn2SubsetUsingTabulation(n1,arr1));
        System.out.println(minDiffIn2SubsetUsingTabulationWithSpaceOptimization(n,arr));
        System.out.println(minDiffIn2SubsetUsingTabulationWithSpaceOptimization(n1,arr1));
    }

    private static int minDiffIn2SubsetUsingTabulationWithSpaceOptimization(int n, int[] arr) {
        int sum=0;
        for(int i:arr)
            sum += i;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        if(arr[0]<=sum)
            dp[arr[0]] = true;
        for(int i=1;i<n;i++){
            boolean[] tmp =new boolean[sum+1];
            tmp[0] = true;
            for(int t=1;t<=sum;t++){
                boolean notTake=dp[t];
                boolean take=false;
                if(arr[i]<t)
                    take = dp[t-arr[i]];
                tmp[t] = take || notTake;
            }
            dp = tmp;
        }
        int min=Integer.MAX_VALUE;
        for(int s1=0;s1<=sum;s1++){
            if(dp[s1])
                min = Math.min(min, Math.abs(s1-(sum-s1)));
        }
        return min;
    }

    private static int minDiffIn2SubsetUsingTabulation(int n, int[] arr) {
        int sum=0;
        for(int i:arr)
            sum += i;
        boolean[][] dp = new boolean[n][sum+1];
        if(arr[0]<=sum)
            dp[0][arr[0]] = true;
        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }
        for(int i=1;i<n;i++){
            for(int t=1;t<=sum;t++){
                boolean notTake = dp[i-1][t];
                boolean take = false;
                if(arr[i]<=t)
                    take = dp[i-1][t-arr[i]];
                dp[i][t] = take || notTake;
            }
        }
        int min=Integer.MAX_VALUE;
        for(int s1=0;s1<=sum;s1++){
            if(dp[n-1][s1])
                min = Math.min(min, Math.abs(s1-(sum-s1)));
        }
        return min;
    }


}
