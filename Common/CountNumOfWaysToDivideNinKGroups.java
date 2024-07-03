package Common; /******************************************************************************

CountWaystoDivide( n , k ) = CountWaystoDivide( n-k , k ) + CountWaystoDivide( n-1 , k-1 ) 

Explanation:
Divide CountWaystoDivide( n , k ) into two parts where

If first element is 1 then the rest form a total  of n-1 divide into k-1 so CountWaystoDivide( n-1 , k-1 )
If first element is greater than 1 then, we can subtract 1 from every element and get a valid partition of n-k into k parts, hence CountWaystoDivide( n-k , k ).

*******************************************************************************/
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
public class CountNumOfWaysToDivideNinKGroups
{
	public static void main(String[] args) {
		int N = 8;
        int K = 4;
 
        System.out.println(countWaystoDivide(N, K));
	}
	
	static int countWaystoDivide(int n, int k)
    {
        if (n < k)
          return 0; // When n is less than k, No way to divide into groups
     
        int [][]dp = new int[n+1][k+1];
        for (int i = 1; i <= n; i++)
          dp[i][1] = 1; // exact one way to divide n to 1 group
        dp[0][0] = 1;
     
        for (int i = 1; i <= n; i++) {
          for (int j = 2; j <= k; j++) {
            if (i >= j)
              dp[i][j] = dp[i - j][j] + dp[i - 1][j - 1];
            else
              dp[i][j] = dp[i - 1][j - 1]; // i<j so dp[i-j][j] becomes zero
          }
        }

        for(int i=0;i<=n;i++){
            for(int j=0; j<=k; j++){
                System.out.print(dp[i][j]+ " ");
            }
            System.out.println();
        }

        return dp[n][k]; // returning number of ways to divide N in k groups
    }
}
