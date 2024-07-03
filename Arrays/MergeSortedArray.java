package Arrays;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String [] args){
        int [] nums1 = new int[]{1,2,3,0,0,0};
        int m=3;
        int [] nums2 = new int[]{2,5,6};
        int n=3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
    public static void merge(int []nums1, int m, int []nums2, int n){
        for(int j=0, i=m; j<n; j++){
            nums1[i] = nums2[j];
            i++;
        }
        Arrays.sort(nums1);
    }
}
