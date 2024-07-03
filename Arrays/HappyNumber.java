package Arrays;
/*
A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.
 */
public class HappyNumber {
    public static void main(String [] args){
        int num=19;
        System.out.println("Happy number: "+ happyNumber(num));
        System.out.println("Happy number: "+ isHappy(num));
        int num1=2;
        System.out.println("Happy number: "+ happyNumber(num1));
        System.out.println("Happy number: "+ isHappy(num1));
    }

    private static boolean happyNumber(int n) {
        int sum=0;
        if(n/10==0){
            return n == 1 || n == 7;
        }
        while(true){
            while(n!=0)
            {
                sum=sum+(n%10)*(n%10);
                n=n/10;
            }
            if(sum==1)
                return true;
            n=sum;
            sum=0;
        }
    }

    public static boolean isHappy(int n) {
        int[] d = getDigits(n);
        if(n==1 || n==7){
            return true;
        }
        if (n<10) {
            return false;
        }
        int sum =0;
        int i=0;
        while (d.length != 1) {
            sum = 0;
            for (int digit : d) {
                sum += (int) Math.pow(digit, 2);
            }
            d = getDigits(sum);
        }
        return sum ==1 || sum ==7;
    }

    static int[] getDigits(int number) {
        int temp = number;
        int count = 0;
        while (temp != 0) {
            temp /= 10;
            count++;
        }
        int[] digits = new int[count];

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }
}
