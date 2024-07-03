package String;

import java.util.List;
/*
Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.
 */
public class LengthOfLastWord {
    public static void main(String[] args){
        String a = "   fly me   to   the moon  ";
        String b = "luffy is still joyboy";
        System.out.println(lengthOfLastWord(a));
        System.out.println(lengthOfLastWord(b));
    }

    private static int lengthOfLastWord(String a) {
        String[] s=a.split(" ");
        int l=s.length;
        return s[l-1].length();
    }
}
