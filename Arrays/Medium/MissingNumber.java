package Arrays.Medium;

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args){
        int a[] = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumberBruteForce(a));
        int a1[] = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumberOptimal1(a1));
        int a2[] = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumberOptimal2(a2));

    }

    private static int missingNumberOptimal1(int[] a) {
        int n = a.length;
        int sum1 = (n*(n+1))/2;
        int sum2 = Arrays.stream(a).sum();
        return sum1-sum2;
    }
    private static int missingNumberOptimal2(int[] a) {
        int n = a.length;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = ans ^ i;
        }
        for (int i = 0; i < n; i++) {
            ans = ans ^ a[i];
        }
        return ans;
    }
    private static int missingNumberBruteForce(int[] a) {
        int n = a.length;
        int[] v = new int[n+1];
        Arrays.fill(v, -1);
        for(int i = 0; i < a.length; i++) {
            v[a[i]] = a[i];
        }
        for(int i = 0; i < v.length; i++) {
            if(v[i] == -1) return i;
        }
        return 0;
    }
}
