package Sorting;

import java.util.ArrayList;

public class DQuickSort {
    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20,9};
        int n = arr.length;
        System.out.println("Before Quick sort:");
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();

        quickSort(arr, 0, n-1);
        System.out.println("After Quick sort:");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low<high){
            int pIndex = partition(arr, low,high);
            /*After placing the pivot in the partition index(within the partition() function specified),
            we need to call the function quickSort() for the left and the right subarray recursively.
            So, the range of the left subarray will be [low to (partition index - 1)] and the range
            of the right subarray will be [(partition index + 1) to high].*/
            quickSort(arr, low, pIndex-1);
            quickSort(arr, pIndex+1, high);
        }
    }
/*
1. Inside the function, we will first select the pivot(i.e. arr[low] in our case).
2. Now, we will again take two-pointers i and j. The i pointer points to low and the j points to high.
3. Now, the pointer i will move forward and find the first element that is greater than the pivot.
   Similarly, the pointer j will move backward and find the first element that is smaller than the pivot.
   Here, we need to add some checks like i <= high-1 and j >= low+1. Because it might happen that i is
   standing at high and trying to proceed or j is standing at low and trying to exceed.
4. Once we find such elements i.e. arr[i] > pivot and arr[j] < pivot, and i < j, we will swap arr[i] and arr[j].
   We will continue step 3 and step 4, until j becomes smaller than i.
5. Finally, we will swap the pivot element(i.e. arr[low]) with arr[j] and will return the index j i.e. the partition index.
 */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i=low;
        int j=high;
        while(i<j){
            while(arr[i]<=pivot && i<=high-1)
                i++;
            while (arr[j]>pivot && j>=low+1)
                j--;
            if(i<j){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        int tmp = arr[low];
        arr[low] = arr[j];
        arr[j] = tmp;
        return j;
    }

}
