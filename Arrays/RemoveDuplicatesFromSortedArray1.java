package Arrays;

public class RemoveDuplicatesFromSortedArray1 {
    static int [] nums2 = new int[]{0,0,1,1,1,1,2,3,3};
    static int [] nums = new int[]{1,1,1,2,2,3,5,6,6,7,7,7};
    static int removeDuplicates(int []nums2){
        int cnt = 1;
        for(int i=1; i<nums2.length; i++){
            if(nums2[i] != nums2[i-1]){
                nums2[cnt] = nums2[i];
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String [] args){
        int cnt = removeDuplicates(nums2);
        for (int i=0;i<cnt; i++){
            System.out.print(" "+ nums2[i]);
        }
        System.out.println();

        int cnt2 = removeDuplicates(nums);
        for (int i=0;i<cnt2; i++){
            System.out.print(" "+ nums[i]);
        }
    }
}
