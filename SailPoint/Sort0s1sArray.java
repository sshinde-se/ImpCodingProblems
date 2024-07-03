package SailPoint;

import java.util.Arrays;

public class Sort0s1sArray {
    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 1, 1, 0, 1, 0 ,0,0};
        System.out.println("Original array: " + Arrays.toString(arr));

        System.out.println("Sorted array: " + Arrays.toString(sortZerosAndOnesUsingTwoPointers(arr)));
        System.out.println("Sorted array: " + Arrays.toString(sortZerosAndOnesUsingCount(arr)));
    }

    private static int[] sortZerosAndOnesUsingCount(int[] arr) {
        long cnt0=0;
        long cnt1=0;
        cnt0 = Arrays.stream(arr).filter(c -> c == 0).count();
        cnt1=arr.length-1-cnt0;
        int i=0;
        while (i<cnt0){
            arr[i]=0;
            i++;
        }
        while (i<cnt1){
            arr[i]=1;
            i++;
        }
        return arr;
    }

    private static int[] sortZerosAndOnesUsingTwoPointers(int[] arr) {
        int l=0;
        int h=arr.length-1;
        while (l<h){
            while(arr[l]==0 && l<h)
                l++;
            while (arr[h]==1 && l<h)
                h++;
            if(l<h){
                arr[l]=0;
                arr[h]=1;
                l++;
                h--;
            }
        }
        return arr;
    }

}
