package Arrays;

import java.util.Arrays;

public class RotateArrayByKTimes {
    public static void main(String [] args){
        int []nums = new int[]{1,2,3,4,5,6,7};
        int k=3;
        rotateArray(nums, k);
        System.out.println("rotated array: "+ Arrays.toString(nums));

        int []nums1 = new int[]{1,2,3,4,5,6,7};
        int k1=4;
        rotateArrayMySolution(nums1, k1);
        System.out.println("rotated array: "+ Arrays.toString(nums1));
    }
    static void rotateArray(int []nums, int k){
        int n = nums.length;
        k = k % n;
        //rotate last k items
        //rotate first n-k items
        //rotate entire array
        for(int i=n-k, j=n-1; i<j; i++, j--){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        for(int i=0, j=n-k-1; i<j; i++, j--){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        for(int i=0, j=n-1; i<j; i++, j--){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
    static void rotateArrayMySolution(int []nums1, int k1){
        int first = 0;
        int j=0;
        while(j<k1){
            int i=1;
            if(nums1.length != 1){
                int tmp=nums1[1];
                nums1[i] = nums1[0];
                while(i+1<nums1.length){
                    first = nums1[i+1];
                    nums1[i+1] = tmp;
                    tmp = first;
                    i++;
                }
                nums1[0] = tmp;
            }
            j++;
        }
    }
}
