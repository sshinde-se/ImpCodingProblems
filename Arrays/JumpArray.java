package Arrays;

/*
You are given an integer array nums. You are initially positioned at the array's first index,
 and each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.
 */
public class JumpArray {
    static boolean canJump(int[] nums) {
        int r=0;
        for(int i=0;i<nums.length;i++){
            if(i>r)
                return false;
            r = Math.max(r, i+nums[i]);
        }
        return true;
    }
    static boolean canJumpMySolution(int[] nums) {
         int n=nums.length;
         if(n==1&&(nums[0] == 0 || nums[0]==1))
             return true;
         for(int i=0; i<n; i++){
             int k = nums[i];
             if(i+k==n-1)
                 return true;
             if(i+k<n-1)
                 i=i+k;
         }
         return false;
     }
    public static void main(String [] args){
        int []nums = new int[]{2,3,1,1,4};
        int []nums1 = new int[]{3,2,1,0,4};
        System.out.println(canJump(nums));
        System.out.println(canJumpMySolution(nums));

        System.out.println(canJump(nums1));
        System.out.println(canJumpMySolution(nums1));
    }
}
