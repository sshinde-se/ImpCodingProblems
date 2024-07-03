package Arrays.Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class MoveAllZerosToEnd {
    public static void main(String []args){
        int [] arr = {1,0,2,3,2,0,0,4,5,1};
        System.out.println("Array of all zeros at end " + Arrays.toString(moveAllZerosToEndBruteForce(arr)));
        System.out.println("Array of all zeros at end Optimal " + Arrays.toString(moveAllZerosToEndOptimal(arr)));
    }

    private static int[] moveAllZerosToEndBruteForce(int[] arr) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i: arr){
            if(i != 0){
                arrayList.add(i);
            }
        }
        int i;
        for(i=0; i< arrayList.size(); i++){
            arr[i] = arrayList.get(i);
        }
        while (i< arr.length){
            arr[i] = 0;
            i++;
        }
        return arr;
    }
    private static int[] moveAllZerosToEndOptimal(int[] nums){
        int j=0;
        for(int k=0;k<nums.length;k++){
            if(nums[k] == 0) {
                j = k;
                break;
            }
        }
        for(int i=j+1;i<nums.length;i++){
            if(nums[i] != 0){
                int tmp=nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                j++;
            }
        }
        return nums;
    }
}
