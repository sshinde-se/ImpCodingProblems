package DynamicProgramming1;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args){
        int[] nums = {0,1,0,3,2,3};
        int res = lis(nums);
        System.out.println(res);
    }

    private static int lis(int[] nums) {
        if(nums.length ==1)
            return 1;
        int[] LIS = new int[nums.length];
        int max=0;
        Arrays.fill(LIS, 1);
        for(int i=nums.length-1; i>=0; i--){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]<nums[j]){
                    LIS[i] = Math.max(1+LIS[j], LIS[i]);
                }
            }
            max=Math.max(max, LIS[i]);
        }
        return max;
    }
}
