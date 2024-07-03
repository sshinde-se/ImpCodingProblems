package HashMap;

import java.util.HashMap;

/*
Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order
of characters. No two characters may map to the same character, but a character may map to itself.
 */
public class IsomorphicStrings {

    public static void main(String[] args){
        String s="egg", t="add";
        String s1="badc", t1="baba";
        System.out.println(isIsomorphic(s,t));
        System.out.println(isIsomorphic(s1,t1));
    }
    public static boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())
            return false;
        HashMap<Character, Character> hmap=new HashMap<>();
        HashMap<Character, Boolean> hmap1= new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);
            if(hmap.containsKey(ch1)){
                if(hmap.get(ch1)!=ch2)
                    return false;
            }
            else{
                if(hmap1.containsKey(ch2))
                    return false;
                else{
                    hmap.put(ch1, ch2);
                    hmap1.put(ch2, true);
                }
            }
        }
        return true;
    }
}
