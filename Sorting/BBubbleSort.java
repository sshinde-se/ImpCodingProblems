package Sorting;

public class BBubbleSort {
    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};
        int n = arr.length;
        System.out.println("Before Bubble sort:");
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
        bubble_sort(arr, n);
        System.out.println("After Bubble sort:");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    private static void bubble_sort(int[] arr, int n) {
        for(int i=0; i<n; i++){
            for(int j=0; j<n-1; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
}
