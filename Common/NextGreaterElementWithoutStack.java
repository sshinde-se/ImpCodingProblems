package Common;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap;

public class NextGreaterElementWithoutStack {
    public static void main(String[] args) {
        int[] array = {9, 72, 45, 19, 19, 99, 1001};

        int[] result = findNextGreaterElement(array);

        System.out.println("Input array: " + Arrays.toString(array));
        System.out.println("Next greater elements: " + Arrays.toString(result));
    }

    private static int[] findNextGreaterElement(int[] array) {
        int[] result = new int[array.length];
        int [] digitSumArr = new int[array.length];
        for(int i=0;i<array.length;i++){
            digitSumArr[i] = calculateDigitSum(array[i]);
        }
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(digitSumArr[j] > digitSumArr[i]){
                    result[i] = array[j];
                    break;
                }
                else if(digitSumArr[j] == digitSumArr[i]){
                    if(array[j] > array[i]){
                        result[i] = array[j]; 
                        break;
                    }
                }
            }
            if(result[i] == 0)
                result[i] = -1;
        }
        return result;
    }
    static int calculateDigitSum(int number){
            int sum=0;
            while(number!=0){
                sum=sum+number%10;
                number=number/10;
            }
            //System.out.println(sum);
            return sum;
        }
}
