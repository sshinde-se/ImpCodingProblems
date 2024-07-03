package Arrays;
/*
Given an array nums, return true if the array was originally sorted in non-decreasing order,
then rotated some number of positions (including zero). Otherwise, return false.
 */
public class CheckIfArrayIsSortedAndRotated {
    public static void main(String[] args){
        int[] arr= {3,4,5,1,2};
        System.out.println(isSortedAndRotated(arr));
        int[] arr1= {2,1,3,4};
        System.out.println(isSortedAndRotated(arr1));
        int[] arr2= {1,2,4,3,8,9};
        System.out.println(isSortedAndRotated(arr2));
    }

    private static boolean isSortedAndRotated(int[] arr) {
        int count=0;
        for(int i=1;i< arr.length;i++){
            if(arr[i]<arr[i-1])
                count++;
        }
        if(arr[0]<arr[arr.length-1])
            count++;
        return count<=1;
    }

}
