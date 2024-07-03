package String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.
 */
public class ValidAnagram {
    public static void main(String[] args){
        String s="anagram", t="nagaram";
        String s1="rat", t1="cat";
        String s2="Hello", t2="hello";
        System.out.println(isAnagram(s,t));
        System.out.println(isAnagram(s1,t1));
        System.out.println(isAnagram(s2,t2));
        System.out.println("Using hashmap:");
        System.out.println(isAnagramUsingHashMap(s,t));
        System.out.println(isAnagramUsingHashMap(s1,t1));
        System.out.println(isAnagramUsingHashMap(s2,t2));
    }
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        String ss = s.toLowerCase();
        String tt = t.toLowerCase();
        char[] ch1=ss.toCharArray();
        char[] ch2=tt.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        ss=new String(ch1);
        tt=new String(ch2);
        return ss.equals(tt);
    }
    private static boolean isAnagramUsingHashMap(String a, String b){
        if(a.length()!=b.length())
            return false;
        String aa = a.toLowerCase();
        String bb = b.toLowerCase();
        char[] cha = aa.toCharArray();
        char[] chb = bb.toCharArray();
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(int i=0;i<cha.length;i++){
            map1.put(cha[i], map1.getOrDefault(cha[i], 0)+1);
            map2.put(chb[i], map2.getOrDefault(chb[i], 0)+1);
        }
        if(map1.size()!=map2.size())
            return false;
        return map1.entrySet().stream().allMatch(e -> e.getValue() == map2.get(e.getKey()));

    }
}
