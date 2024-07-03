package ServiceNowCoding;
/*
Print prime numbers which is less than or equal to given number
 */
public class PrintPrimeNumbers {
    public static void main(String[] args){
        int n=10;
        printPrimeNumbers(n);
        System.out.println();
        int n1=100;
        printPrimeNumbers(n1);
    }

    private static void printPrimeNumbers(int n) {
        boolean flag;
        for(int i=2;i<n;i++){
            flag = i != 4;
            for(int j=2;j<i/2;++j){
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                System.out.print(i +" ");
        }
    }
}
