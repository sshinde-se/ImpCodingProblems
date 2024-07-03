package Arrays;


public class RemoveElementFromArray {
    static int [] nums2 = new int[]{0,1,2,2,3,0,4,2};
    static int [] nums = new int[]{3,2,2,3};

    static int removeElement(int []nums2, int val){
        int cnt=0;
        for(int i=0; i<nums2.length; i++){
            if(nums2[i] != val){
                nums2[cnt] = nums2[i];
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String [] args){
        int val1=2;
        int cnt = removeElement(nums2, val1);
        for (int i=0;i<cnt; i++){
            System.out.print(" "+ nums2[i]);
        }
        System.out.println();
        int val2=3;
        int cnt2 = removeElement(nums, val2);
        for (int i=0;i<cnt2; i++){
            System.out.print(" "+ nums[i]);
        }
    }
}
