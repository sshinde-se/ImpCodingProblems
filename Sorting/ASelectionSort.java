package Sorting;

public class ASelectionSort {
    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};
        int n = arr.length;
        System.out.println("Before selection sort:");
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
        selection_sort(arr, n);
        System.out.println("After selection sort:");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    private static void selection_sort(int[] arr, int n) {
        for(int i=0;i<n-1;i++){ // last element we don't need to sort hence n-1
            int min = i;
            for(int j=i+1; j<n;j++){
                if(arr[j] < arr[min])
                    min = j;
            }
            int tmp = arr[min];
            arr[min] = arr[i];
            arr[i] = tmp;
        }
    }
}
