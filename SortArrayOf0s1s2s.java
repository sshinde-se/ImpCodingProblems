/******************************************************************************


Sort an array of 0s, 1s and 2s | Dutch National Flag problem

*******************************************************************************/
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
public class SortArrayOf0s1s2s
{
	static void printArr(int[] arr, int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
 
    // Function to sort the array of 0s, 1s and 2s
    static void sortArr(int[] arr, int n)
    {
        int i, cnt0 = 0, cnt1 = 0, cnt2 = 0;
 
        // Count the number of 0s, 1s and 2s in the array
        for (i = 0; i < n; i++) {
            switch (arr[i]) {
                case 0 -> cnt0++;
                case 1 -> cnt1++;
                case 2 -> cnt2++;
            }
        }
 
        // Update the array
        i = 0;
 
        // Store all the 0s in the beginning
        while (cnt0 > 0) {
            arr[i++] = 0;
            cnt0--;
        }
 
        // Then all the 1s
        while (cnt1 > 0) {
            arr[i++] = 1;
            cnt1--;
        }
 
        // Finally all the 2s
        while (cnt2 > 0) {
            arr[i++] = 2;
            cnt2--;
        }
 
        // Print the sorted array
        printArr(arr, n);
    }
 
    // Driver code
    public static void main(String[] args)
    {
        int[] arr = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        int n = arr.length;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        sortArr(arr, n);

    }
}
