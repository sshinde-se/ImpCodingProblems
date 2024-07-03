package MathCalculations;

/*
This question is pretty straightforward.

Because all trailing 0 is from factors 5 * 2.

But sometimes one number may have several 5 factors, for example, 25 have two 5 factors,
125 have three 5 factors. In the n! operation, factors 2 is always ample.
So we just count how many 5 factors in all number from 1 to n.
 */
public class FactorialTrailingZeros {
    public static void main(String []args){
        int x=30;
        System.out.println(factorialTrailingZeros(x));
    }

    private static int factorialTrailingZeros(int x) {
        int count=0;
        while(x!=0){
            x/=5;
            count+=x;
        }
        return count;
    }
}
