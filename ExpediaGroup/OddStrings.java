package ExpediaGroup;

import java.util.ArrayList;
import java.util.List;
/*
Sum of string is calculated like
ex. abc
sumOfa = Math.pow(97,m) = 9409
sumOfb = sumOfa * Math.pow(98,m) = 9409 * 9604 = 90364036
sumOfc = sumOfb * Math.pow(99,m) = 90364036 * 9801 = 885657916836
 */
public class OddStrings {
    public static void main(String[] args){
        List<String> s = new ArrayList<>();
        s.add("abc");
        s.add("abcd");
        oddStrings(s, 2);
    }

    private static void oddStrings(List<String> s, int m) {
        String[] str = new String[s.size()];
        for(int i=0;i<s.size();i++){
            str[i] = s.get(i);
        }
        for(String s1: str){
            long sum = calculateSum(s1, m);
            if(sum%2==0)
                System.out.println("EVEN");
            else
                System.out.println("ODD");
        }
    }

    private static long calculateSum(String s, int m) {
        long sum=0;
        char c = s.charAt(0);
        int a = Character.getNumericValue(c);
        sum += Math.pow(a, m);
        for(int i=1; i<s.length();i++){
            char c1 = s.charAt(i);
            long a1 = (int)c1;
            sum *= Math.pow(a1, m);
        }
        System.out.println(sum);
        return sum;
    }
}
