package ExpediaGroup;

import java.util.ArrayList;
import java.util.List;

public class MissingWords {
    public static void main(String[] args){
        String a = "I like cheese";
        String b = "like";
        List<String> l = missingWords(a, b);
        System.out.println(l);

        String a1= "I am using Hackerrank to improve programming";
        String a2= "am Hackerrank to improve";
        List<String> l1 = missingWords(a1, a2);
        System.out.println(l1);
    }

    private static List<String> missingWords(String a, String b) {
        String[] s1 = a.split(" ");
        String[] s2 = b.split(" ");
        int i=0, j=0;
        List<String> l= new ArrayList<>();
        while(i< s1.length && j< s2.length){
            if(s1[i].equals(s2[j])){
                i++;
                j++;
            }
            else{
                l.add(s1[i]);
                i++;
            }
        }
        while (i< s1.length){
            l.add(s1[i]);
            i++;
        }
        return l;
    }
}
