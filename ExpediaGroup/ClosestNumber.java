package ExpediaGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestNumber {
    public static void main(String[] args){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(6);
        numbers.add(2);
        numbers.add(4);
        numbers.add(10);
        closestNumbers(numbers);
    }

    private static void closestNumbers(List<Integer> numbers) {
        int min = Integer.MAX_VALUE;
        int[] arr = new int[numbers.size()];
        for(int i=0; i<numbers.size();i++){
            arr[i] = numbers.get(i);
        }
        Arrays.sort(arr);
        for(int i=0; i<arr.length-1; i++){
            int diff = Math.abs(arr[i] - arr[i+1]);
            if(diff < min){
                min = diff;
            }
        }
        for(int i=0; i< arr.length-1;i++){
            if(Math.abs(arr[i]-arr[i+1]) == min)
                System.out.println(arr[i] + " " + arr[i+1]);
        }
    }
}
