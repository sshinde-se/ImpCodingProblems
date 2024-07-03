package HashMap;

import java.util.Arrays;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] hash = new int[256];
        Arrays.fill(hash, 0);
        for(int i=0;i<magazine.length();i++){
            hash[magazine.charAt(i)]++;
        }
        for(int i=0;i<ransomNote.length();i++){
            hash[ransomNote.charAt(i)]--;
        }
        for (int j : hash) {
            if (j < 0)
                return false;
        }
        return true;
    }
    public static void main(String []args){
        String ransomNote = "aa", magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
        String ransomNote1 = "aa", magazine1 = "ab";
        System.out.println(canConstruct(ransomNote1, magazine1));
    }
}
