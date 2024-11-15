package DynamicProgramming.Medium.Strings;
import java.util.Arrays;
/*
We are given two strings ‘S1’ and ‘S2’. We need to convert S1 to S2. The following three operations
are allowed:

Deletion of a character.
Replacement of a character with another one.
Insertion of a character.

We have to return the minimum number of operations required to convert S1 to S2 as our answer.

Approach:
s1: "horse", s2: "ros"
(i) When the characters match

if(S1[i]==S2[j]),

If this is true, now as the characters at i and j match, we would not want to do any operations
to make them match, so we will just decrement both i and j by 1 and recursively find the answer
for the remaining string portion. We return 0+f(i-1,j-1). The following figure makes it clear.

(ii) When the characters don’t match

if(S1[i] != S2[j]) is true, then we have to do any of three operations to match the characters.
We have three options, we will analyze each of them one by one.

Case 1: Inserting a character
We would have placed an ‘s’ at index 5 of S1.
Suppose i now point to s at index 5 of S1 and j points are already pointing to s at index j of S2.
Now, we hit the condition, where characters do match. (as mentioned in case 1).
Therefore, we will decrement i and j by 1. They will now point to index 4 and 1 respectively

Now, the number of operations we did were only 1 (inserting s at index 5) but do we need to really
insert the ‘s’ at index 5 and modify the string? The answer is simply NO. As we see that inserting
a character (here ‘s’ at index 5), we will eventually get to the third step. So we can just
return 1+ f(i,j-1) as i remains there only after insertion and j decrements by 1. We can say that
we have hypothetically inserted character s.

Case 2: Deleting a character
We can simply delete the character at index 4 and check from the next index.
Now, j remains at its original index and we decrement i by 1. We perform 1 operation,
therefore we will recursively call 1+f(i-1,j).

Case 3: Replacing a character
If we replace the character ‘e’ at index 4 of S1 with ‘s’, we have matched both the characters
ourselves. We again hit the case of character matching, therefore we decrement both i and j by 1.
As the number of operations performed is 1, we will return 1+f(i-1,j-1).

To summarise, these are the three choices we have in case characters don’t match:

return 1+f(i-1,j) // Insertion of character.
return 1+f(i,j-1) // Deletion of character.
return 1+f(i-1,j-1) // Replacement of character.
Step 3: Return the minimum of all choices.
As we have to return the minimum number of operations, we will return the minimum of all operations.

 */
public class IEditDistance {
    public static void main(String args[]) {
        String s1 = "horse";
        String s2 = "ros";

        System.out.println("Minimum number of operations required is: " + editDistanceMemo(s1, s2));
        System.out.println("Minimum number of operations required is: " + editDistanceTabulation(s1, s2));
        System.out.println("Minimum number of operations required is: " + editDistanceSpaceOptimization(s1, s2));
    }

    private static int editDistanceSpaceOptimization(String s1, String s2) {
        int n=s1.length(),m=s2.length();
        int[] dp = new int[m+1];
        for(int i=0;i<=m;i++){
            dp[0] = i;
        }

        for(int i=1;i<=n;i++){
            int[] tmp = new int[m+1];
            tmp[0] = i;
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    tmp[j] = dp[j-1];
                else
                    tmp[j] = 1 + Math.min(tmp[j-1], Math.min(dp[j], dp[j-1]));
            }
            dp=tmp;
        }
        return dp[m];
    }

    private static int editDistanceTabulation(String s1, String s2) {
        int n=s1.length(),m=s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = i;
        }
        for(int j=1;j<=m;j++){
            dp[0][j] = j;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
            }
        }
        return dp[n][m];
    }

    private static int editDistanceMemo(String s1, String s2) {
        int n=s1.length(),m=s2.length();
        int[][] dp = new int[n][m];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return minOperations(n-1,m-1,s1,s2,dp);
    }

    private static int minOperations(int i, int j, String s1, String s2, int[][] dp) {
        if(j<0)
            return i+1;
        if(i<0)
            return j+1;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = minOperations(i-1,j-1,s1,s2,dp);
        return dp[i][j] = 1+ Math.min(minOperations(i,j-1,s1,s2,dp),
                                    Math.min(minOperations(i-1,j,s1,s2,dp),minOperations(i-1,j-1,s1,s2,dp)));
    }
}
