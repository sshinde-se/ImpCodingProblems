package Sorting;

import java.util.ArrayList;

public class CMergeSort {
    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20,9};
        int n = arr.length;
        System.out.println("Before Merge sort:");
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
        merge_sort(arr, n);
        System.out.println("After Merge sort:");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    private static void merge_sort(int[] arr, int n) {
        mergeSort(arr, 0, n-1);
    }
    private static void mergeSort(int[] arr, int low, int high){
        if(low>=high)
            return;
        int mid = (low+high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }
    private static void merge(int[] arr, int low, int mid, int high){
        ArrayList<Integer> list= new ArrayList<>();
        int l=low,r=mid+1;

        while (l<= mid && r<=high){
            if(arr[l] < arr[r]){
                list.add(arr[l]);
                l++;
            }
            else{
                list.add(arr[r]);
                r++;
            }
        }
        while(l<=mid){
            list.add(arr[l]);
            l++;
        }
        while(r<=high){
            list.add(arr[r]);
            r++;
        }
        for(int i=low; i<=high; i++){
            arr[i] = list.get(i-low);
        }
    }
}
