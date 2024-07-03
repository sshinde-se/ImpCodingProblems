package String;

public class ReverseWords {
    public static void main(String[] args){
        String a = "a good   example";
        String b = "  hello world   ";
        System.out.println(reverseWords(a));
        System.out.println(reverseWords(b));
    }

    private static String reverseWords(String a) {
        String[] str = a.trim().split("\\s+");
        String res = "";
        for(int i=str.length-1; i>=0;i--){
            res+=str[i]+" ";
        }
        return res.trim();
    }
}
