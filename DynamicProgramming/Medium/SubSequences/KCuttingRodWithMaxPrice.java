package DynamicProgramming.Medium.SubSequences;

import java.util.Arrays;

/*
We are given a rod of size �N�. It can be cut into pieces. Each length of a piece has a particular price
given by the price array. Our task is to find the maximum revenue that can be generated by selling the
rod after cutting( if required) into pieces.

N=8
Price[] = {3, 5, 8, 9, 10, 17, 17, 20}
Output:
24
Explanation:
The maximum obtainable value is
24 by cutting the rod into 8 pieces
of length 1, i.e, 8*price[1]= 8*3 = 24.

This problem is similar to UnBoundedKnapSack.java

Here rod will be cut into pieces with help of indexes
1 based indexing used i.e 0 index denote 1 length, 1 index denote 2 length and so on.
Here N=8
means we can cut rod with indexes like 1,2,3,4,5,6,7,8

while considering index we need to maximize the price, we will generate all sequences as brute force
 */
public class KCuttingRodWithMaxPrice {
    public static void main(String[] args){
        int N=8;//length of rod
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};

        System.out.println("Get max price by cutting rod into pieces: "+ calMaxPriceMemo(N,price));
        System.out.println("Get max price by cutting rod into pieces: "+ calMaxPriceUsingTabulation(N,price));
        System.out.println("Get max price by cutting rod into pieces: "+ calMaxPriceUsingSpaceOptimization(N,price));
    }

    private static int calMaxPriceUsingSpaceOptimization(int N, int[] price) {
        int n=price.length;
        int[] dp = new int[N+1];
        for(int i=0;i<=N;i++)
            dp[i] = i * price[0];
        for(int i=1;i<n;i++){
            int[] tmp = new int[N+1];
            for(int j=0;j<=N;j++){
                int notTake = dp[j];
                int take = (int) Math.pow(-10,9);
                int rod_length = i+1;
                if(rod_length<=j)
                    take = price[i] + dp[j-rod_length];
                tmp[j] = Math.max(take,notTake);
            }
            dp =tmp;
        }
        return dp[N];
    }

    private static int calMaxPriceUsingTabulation(int N, int[] price) {
        int n=price.length;
        int[][] dp =new int[n][N+1];
        for(int i=0;i<=N;i++)
            dp[0][i] = i*price[0];
        for(int i=1;i<n;i++){
            for(int j=0;j<=N;j++){
                int notTake = dp[i-1][j];
                int take = (int) Math.pow(-10,9);
                int rod_length = i+1; // 1 based indexing
                if(rod_length <= j)
                    take = price[i] + dp[i][j-rod_length]; // we stayed at same index i as we can take any no. of that rod length
                dp[i][j] = Math.max(take, notTake);
            }
        }
        return dp[n-1][N];
    }

    private static int calMaxPriceMemo(int N, int[] price) {
        int n=price.length;
        int[][] dp = new int[n][N+1];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return maxPrice(n-1,N,price,dp);
    }

    private static int maxPrice(int i, int N, int[] price, int[][] dp) {
        if(i==0){
            return N * price[0]; //most imp: as we have rod length=N and i=0 means 1, so we need have rod
                                // length of N from this 1 so 1*1*1*1...N will give N length rod and we need to return price for that hence N * price[0]
        }
        if(dp[i][N]!=-1)
            return dp[i][N];
        int notTake = maxPrice(i-1,N,price,dp);
        int take = (int) Math.pow(-10,9);
        int rod_length = i+1; // 1 based indexing
        if(rod_length <= N)
            take = price[i] + maxPrice(i, N-rod_length, price,dp); // we stayed at same index i as we can take any no. of that rod length
        return dp[i][N] = Math.max(take, notTake);
    }
}