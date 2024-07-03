package MathCalculations;

public class PowFunction {
    public static void main(String []args){
        double x=2.10000;
        int n=3;
        System.out.println(myPow(x,n));
        double x1=2.0000;
        int n1=-2;
        System.out.println(myPow(x1,n1));
        double x2=1.00000;
        int n2=2147483647;
        System.out.println(myPow(x2,n2));
    }

    private static double myPow(double x, int n) {
        double out = x;
        int n1=0;
        if(n<0)
            n1=n*-1;
        else
            n1=n;
        for(int i=1;i<n1;i++){
            out = out * x;
        }
        if(n<0){
            out=1/out;
        }
        return out;
    }
}
