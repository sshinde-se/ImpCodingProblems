package Arrays;

import java.util.Arrays;

public class SearchInsertPosition {
    public static void main(String [] args){
        int []nums = new int[]{2,3,4,10,40};
        int target=10;
        System.out.println(insertPosition(nums, target));
    }

    private static int insertPosition(int[] nums, int target) {
        int first =0;
        int last=nums.length-1;
        int mid = 0;
        while(first<=last){
            mid = (last+first)/2;
            if(nums[mid]>target)
                last=mid-1;
            else if(target==nums[mid])
                return mid;
            else
                first=mid+1;
        }
        return first;
    }
}
