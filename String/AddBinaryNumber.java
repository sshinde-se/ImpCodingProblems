package String;
/*
Given two binary strings a and b, return their sum as a binary string.
Input: a = "1010", b = "1011"
Output: "10101"
 */
public class AddBinaryNumber {
    public static void main(String[] args){
        String a="1010", b="1011";
        System.out.println(addBinary(a,b));
    }

    private static String addBinary(String a, String b) {
        int c=0, i=a.length()-1, j=b.length()-1;
        StringBuilder s= new StringBuilder();
        while (i>=0 || j>=0 || c==1){
            if(i>=0)
                c += a.charAt(i--) - '0';
            if(j>=0)
                c += b.charAt(j--) - '0';
            s.append(c%2);
            c = c/2;
        }
        return s.reverse().toString();
    }
}
