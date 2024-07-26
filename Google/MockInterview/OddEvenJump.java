package Google.MockInterview;

import java.util.Map;
import java.util.TreeMap;

/*
You are given an integer array arr. From some starting index, you can make a series of jumps. The (1st, 3rd, 5th, ...) jumps in the series are called odd-numbered jumps, and the (2nd, 4th, 6th, ...) jumps in the series are called even-numbered jumps. Note that the jumps are numbered, not the indices.

You may jump forward from index i to index j (with i < j) in the following way:

During odd-numbered jumps (i.e., jumps 1, 3, 5, ...), you jump to the index j such that arr[i] <= arr[j] and arr[j] is the smallest possible value. If there are multiple such indices j, you can only jump to the smallest such index j.
During even-numbered jumps (i.e., jumps 2, 4, 6, ...), you jump to the index j such that arr[i] >= arr[j] and arr[j] is the largest possible value. If there are multiple such indices j, you can only jump to the smallest such index j.
It may be the case that for some index i, there are no legal jumps.
A starting index is good if, starting from that index, you can reach the end of the array (index arr.length - 1) by jumping some number of times (possibly 0 or more than once).

Return the number of good starting indices.

Input: arr = [10,13,12,14,15]
Output: 2
Explanation:
From starting index i = 0, we can make our 1st jump to i = 2 (since arr[2] is the smallest among arr[1], arr[2], arr[3], arr[4] that is greater or equal to arr[0]), then we cannot jump any more.
From starting index i = 1 and i = 2, we can make our 1st jump to i = 3, then we cannot jump any more.
From starting index i = 3, we can make our 1st jump to i = 4, so we have reached the end.
From starting index i = 4, we have reached the end already.
In total, there are 2 different starting indices i = 3 and i = 4, where we can reach the end with some number of
jumps.
 */
public class OddEvenJump {
    public static void main(String[] args){
//        int[] arr1={10,13,12,14,15};
//        System.out.println("Number of good starting indices through we reach last by jump: "+ oddEvenJumpsUsingTreeMap(arr1));
//        int[] arr={5,4,3,2,1};
//        System.out.println("Number of good starting indices through we reach last by jump: "+ oddEvenJumpBruteForce(arr));
        int[] arr2={81,54,96,60,58};
        System.out.println("Number of good starting indices through we reach last by jump: "+ oddEvenJumpBruteForce(arr2));
    }

    private static int oddEvenJumpBruteForce(int[] arr) {
        int count=1;
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            int jump_count = 1;
            int j=i+1;
            if(j == n-1){
                if(arr[j] >=arr[i])
                    count++;
                break;
            }
            for(j=i+1;j<n;j++){
                if(jump_count%2!=0){
                    int min_diff = Integer.MAX_VALUE;
                    int m=0;
                    for(int k=j;k<n;k++){
                        int max=arr[j-1];
                        if(arr[k]>=max){
                            max= arr[k];
                            if((max-arr[j-1])<min_diff){
                                min_diff = max-arr[j-1];
                                m=k;
                            }
                        }
                    }
                    if(min_diff!=Integer.MAX_VALUE){
                        j=m;
                        jump_count++;
                        if(j==n-1)
                            break;
                    }
                    else
                        break;
                }
                if(jump_count%2==0){
                    int min_diff = Integer.MAX_VALUE;
                    int m=0;
                    for(int k=j+1;k<n;k++){
                        int min=arr[j];
                        if(arr[k]<=min){
                            min= arr[k];
                            // min_diff=Math.min(min_diff, max-arr[i]);
                            if((arr[j]-min)<min_diff){
                                min_diff = arr[j]-min;
                                m=k;
                            }
                        }
                    }
                    if(min_diff!=Integer.MAX_VALUE){
                        j=m;
                        jump_count++;
                        if(j==n-1)
                            break;;
                    }
                    else
                        break;
                }
            }
            if(j==n-1)
                count++;
        }
        return count;
    }
    private static int oddEvenJumpsUsingTreeMap(int[] arr){
        int jumpsPossible= 1; // last index jump is always possible, as we can drectly jump to last element

        int len = arr.length;

        boolean[] isOddJumpPossible =  new boolean[len]; // is odd jump is possible at this index?
        boolean[] isEvenJumpPossible =  new boolean[len]; // is even jump is possible at this index?

        TreeMap<Integer, Integer> map = new TreeMap<>(); // value - index

        // last element is always possible jump
        isOddJumpPossible[len-1] = true;
        isEvenJumpPossible[len-1] = true;
        map.put(arr[len-1], len-1);


        for(int i = len - 2; i >= 0; i--) {

            Map.Entry<Integer, Integer> elementIfOddJump = map.ceilingEntry(arr[i]); //get next entry if odd jump is taken from current element.
            Map.Entry<Integer, Integer> elementIfEvenJump = map.floorEntry(arr[i]);  //get next entry if even jump is taken from current element.

            // if we can take odd jump from current index
            if(elementIfOddJump != null) {
                // check if next even jump is possible at next element's index, because current is odd jump
                isOddJumpPossible[i] = isEvenJumpPossible[elementIfOddJump.getValue()];
            }
            // if we can take even jump from current index
            if(elementIfEvenJump != null) {
                isEvenJumpPossible[i] = isOddJumpPossible[elementIfEvenJump.getValue()];
            }

            // if we consider this element at ith index as first jump, it's odd jump as it will be 1st jump
            if(isOddJumpPossible[i]) {
                jumpsPossible++;
            }

            map.put(arr[i], i);
        }

        return jumpsPossible;
    }
}
