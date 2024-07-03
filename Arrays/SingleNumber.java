package Arrays;

import java.util.HashMap;
import java.util.Map;

/*
Given a non-empty array of integers nums,
every element appears twice except for one. Find that single one.
Input: nums = [4,1,2,1,2]
Output: 4
 */
public class SingleNumber {
    public static void main(String [] args){
        int []nums = new int[]{4,1,2,1,2};
        int[] nums1 = new int[]{2,2,1};
        System.out.println("Single number: "+ singleNumber(nums));
        System.out.println("Single number: "+ singleNumberUsingXOR(nums));
    }

    private static int singleNumberUsingXOR(int[] nums) {
        int ans=0;
        for (int num : nums) {
            ans = ans ^ num;
        }
        return ans;
    }

    private static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i: nums){
            hmap.put(i, hmap.getOrDefault(i, 0)+1);
        }
        for(Map.Entry<Integer,Integer> h: hmap.entrySet()){
            if(h.getValue() == 1)
                return h.getKey();
        }
        return 0;
    }
}
