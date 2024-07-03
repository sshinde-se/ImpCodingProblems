package DynamicProgramming1;

import java.util.Arrays;

public class HouseRobber {
    static int robUsing2VarBottomUp(int [] nums){
        int n = nums.length;
        int p1=0, p2=0;
        for (int num : nums) {
            int tmp = p1;
            p1 = Math.max(p2 + num, p1);
            p2 = tmp;
        }
        return Math.max(p1, p2);
    }

    //Using recursion + memo(top down)
    static int[] memo;
    static int rob(int[] nums){
        memo = new int[nums.length+1];
        Arrays.fill(memo, -1);
        return rob(nums, nums.length-1);
    }
    static int rob(int[] nums, int i){
        if(i<0)
            return 0;
        if(memo[i]>=0)
            return memo[i];
        int res = Math.max(rob(nums, i-2)+nums[i], rob(nums, i-1));
        memo[i] = res;
        return res;
    }
    public static void main(String[] args){
        int[] n = {2,7,9,3,1}; // Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
                                //Total amount you can rob = 2 + 9 + 1 = 12.
        int[] n1 = {2,1,1,2};


        System.out.println(rob(n));
        System.out.println(robUsing2VarBottomUp(n));

        System.out.println(rob(n1));
        System.out.println(robUsing2VarBottomUp(n1));
    }
}
