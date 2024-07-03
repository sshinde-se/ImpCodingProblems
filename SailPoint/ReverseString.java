package SailPoint;

public class ReverseString {
    public static void main(String [] args){
        String s = "A man, a plan, a canal: Panama";
        System.out.println("Reverse string: "+ reverseStringUsingCharArray(s));
        System.out.println("Reverse string: "+ reverseStringUsingStringBuilder(s));
        System.out.println("Reverse string: "+ reverseStringUsingDiffVariable(s));
    }

    private static String reverseStringUsingDiffVariable(String s) {
        String r="";
        for(int i=s.length()-1;i>=0;i--){
            r += s.charAt(i);
        }
        return r;
    }

    private static String reverseStringUsingStringBuilder(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private static String reverseStringUsingCharArray(String s) {
        char[] ch = s.toCharArray();
        int l=0;
        int h=s.length()-1;
        while (l<h){
            char tmp = ch[l];
            ch[l] = ch[h];
            ch[h] = tmp;
            l++;
            h--;
        }
        return new String(ch);
    }
}
