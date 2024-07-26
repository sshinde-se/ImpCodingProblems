package String; /******************************************************************************

Longest Consecutive Subsequence using sorting without removing duplicate elements

*******************************************************************************/
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
public class LongestConsecutiveSubsequence
{
    public static void main(String [] args){
        int[] arr = {0,1,1,1,1,1,2,3};
        int N = arr.length;
        if(N == 1){
            System.out.println("Longest Consecutive subsequence: 1");
            return;
        }
        System.out.println("Longest Consecutive subsequence using Hashing: "+longestConsecutiveSubsequenceHashing(arr));
        System.out.println("Longest Consecutive subsequence: "+longestConsecutiveSubsequenceBruteForce(arr));

        int[] arr1={36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42};
        System.out.println("Longest Consecutive subsequence using Hashing: "+longestConsecutiveSubsequenceHashing(arr1));
        System.out.println("Longest Consecutive subsequence: "+longestConsecutiveSubsequenceBruteForce(arr1));

    }

    private static int longestConsecutiveSubsequenceHashing(int[] arr) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i: arr){
            hashSet.add(i);
        }
        int ans=0;
        for(int i=0;i< arr.length;i++){
            if(!hashSet.contains(arr[i]-1)){
                int j = arr[i];
                while (hashSet.contains(j))
                    j++;
                if(ans<j-arr[i])
                    ans = j - arr[i];
            }
        }
        return ans;
    }

    private static int longestConsecutiveSubsequenceBruteForce(int[] arr){
        Arrays.sort(arr);
        int count = 1;
        int max_count = -1;
        for(int i=0; i < arr.length-1; i++)
        {
            int i1 = arr[i + 1] - arr[i];
            if(i1 == 1) {
                count++;
            }
            else if(i1 == 0) {
                continue;
            }
            else {
                count = 1;
            }
            max_count = Math.max(max_count, count);
        }
        return max_count;
    }
}
