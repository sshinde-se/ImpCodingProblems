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
           
            Arrays.sort(arr);
            int count = 1;
            int max_count = -1;
            for(int i=0; i < N-1; i++)
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
          System.out.println("Longest Consecutive subsequence: "+max_count);
    }
}
