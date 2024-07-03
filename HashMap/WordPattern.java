package HashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;

/*
Given a pattern and a string s, find if s follows the same pattern.
Here follow means a full match, such that there is a bijection between
a letter in pattern and a non-empty word in s

ex:
Input: pattern = "abba", s = "dog cat cat dog"
Output: true

Input: pattern = "abba", s = "dog cat cat fish"
Output: false
 */
public class WordPattern {
    public static void main(String[] args){
        String s="abba", t="dog cat cat dog";
        String s1="aaaa", t1="dog cat cat dog";
        System.out.println(wordPattern(s,t));
        System.out.println(wordPattern(s1,t1));
    }
    public static boolean wordPattern(String pattern, String s) {
        String[] sarr=s.split(" ");
        if(sarr.length!=pattern.length())
            return false;
        HashMap<Character, String> hmap=new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            char ch=pattern.charAt(i);
            if(hmap.containsKey(ch)){
                if(!hmap.get(ch).equals(sarr[i]))
                    return false;
            }
            else{
                if(hmap.containsValue(sarr[i]))
                    return false;
                hmap.put(ch, sarr[i]);
            }
        }
        return true;
    }
}
