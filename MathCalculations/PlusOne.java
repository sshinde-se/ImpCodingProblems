package MathCalculations;

import java.util.Arrays;

/*
You are given a large integer represented as an integer array digits, where each digits[i]
is the ith digit of the integer. The digits are ordered from most significant to least significant
in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: Incrementing by one gives 4321 + 1 = 4322. Thus, the result should be [4,3,2,2].

Input: digits = [9]
Output: [1,0]
Explanation: Incrementing by one gives 9 + 1 = 10. Thus, the result should be [1,0].

 */
public class PlusOne {
    public static void main(String []args){
        int[] digits=new int[]{4,3,2,1};
        System.out.println(Arrays.toString(plusOne(digits)));
        int[] digits1=new int[]{9,9,9,9};
        System.out.println(Arrays.toString(plusOne(digits1)));
    }

    private static int[] plusOne(int[] x) {
        for(int i=x.length-1; i>=0; i--){
            if(x[i]<9){
                x[i]++;
                return x;
            }
        }
        x=new int[x.length+1];
        x[0]=1;
        return x;
    }
}
