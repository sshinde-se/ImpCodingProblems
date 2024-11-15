package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String [] args){
        int []nums = new int[]{2,7, 11, 15,0,-2};
        int target=9;
        int[] nums1 = new int[]{3,2,4};
        int target1=6;
        System.out.println("two sum: "+ Arrays.toString(twoSumMySolution(nums, target)));
        System.out.println("two sum: "+ Arrays.toString(twoSumUsingHashMap(nums, target)));
        System.out.println("two sum: "+ Arrays.toString(twoSumMySolution(nums1, target1)));
        System.out.println("two sum: "+ Arrays.toString(twoSumUsingHashMap(nums1, target1)));
    }

    private static int[] twoSumMySolution(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
    private static int[] twoSumUsingHashMap(int[] nums, int target) {
        Map<Integer, Integer> hmap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int diff = target - nums[i];
            if(hmap.containsKey(diff)){
                return new int[]{hmap.get(diff), i};
            }
            hmap.put(nums[i], i);
        }
        return new int[]{};
    }
}
