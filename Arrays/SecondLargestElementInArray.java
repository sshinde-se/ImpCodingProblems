package Arrays;

import java.util.Arrays;

public class SecondLargestElementInArray {
    public static void main(String []args){
        int [] arr = new int[]{7,1,5,3,6,4};
        System.out.println("Second Largest: " + secondLargestElement(arr));
        int [] arr1 = new int[]{2,7,8,1,5,3,6,4};
        System.out.println("Second Largest: " + secondLargestElement(arr1));
    }

    private static int secondLargestElement(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > max) {
                secondMax = max;
                max = j;
            } else if (j > secondMax && j != max) {
                secondMax = j;
            }
        }
        return secondMax;
    }

}
