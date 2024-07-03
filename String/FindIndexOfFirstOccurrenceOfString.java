package String;

public class FindIndexOfFirstOccurrenceOfString {
    public static void main(String[] args){
        String a = "butsad";
        String b = "sad";
        System.out.println(indexOfFirstOccurrenceOfString(a, b));
    }

    public static int indexOfFirstOccurrenceOfString(String haystack, String needle) {
        int h=haystack.length();
        int n=needle.length();
        if(h<n)
            return -1;
        for(int i=0;i<=h-n;i++){
            int j=0;
            while(j<n && haystack.charAt(i+j) == needle.charAt(j)){
                j++;
            }
            if(j==n)
                return i;
        }
        return -1;
    }
}
