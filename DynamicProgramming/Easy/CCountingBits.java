package DynamicProgramming.Easy;

import java.util.Arrays;

public class CCountingBits {
    public static void main(String[] args){
        int n=5;
        System.out.println("Count no of 1s for each number from 0 to n for there binary representation: "+ Arrays.toString(count1sUsingBuckets(n)));
        System.out.println("Count no of 1s for each number from 0 to n for there binary representation: "+ Arrays.toString(count1sUsingRightShiftOperator(n)));
        int n1=23;
        System.out.println("Count no of 1s for each number from 0 to n for there binary representation: "+ Arrays.toString(count1sUsingBuckets(n1)));
        System.out.println("Count no of 1s for each number from 0 to n for there binary representation: "+ Arrays.toString(count1sUsingRightShiftOperator(n1)));
    }

    private static int[] count1sUsingBuckets(int n) {
        int[] ans = new int[n+1];
        int offset=1;
        for(int i=1;i<=n;i++){
            if(offset*2 == i)
                offset = offset * 2;
            ans[i] = ans[i-offset] + 1;
        }
        return ans;
    }
    private static int[] count1sUsingRightShiftOperator(int n){
        int[] ans = new int[n+1];
        for(int i=0;i<=n;i++){
            ans[i] = ans[i >> 2] + (i & 1);// equivalent to ans[i] = ans[i/2] + i % 2;
        }
        return ans;
    }
}
