package String;

import java.util.Arrays;
/*
Input: strs = ["flower","flow","flight"]
Output: "fl"

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {
    public static void main(String[] args){
        String[] a = {"flower","flow","flight"};
        String[] b = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(a));
        System.out.println(longestCommonPrefix(b));
    }

    private static String longestCommonPrefix(String[] a) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(a);
        String first = a[0];
        String last = a[a.length-1];
        for(int i=0; i<Math.min(first.length(), last.length()); i++){
            if(first.charAt(i)!=last.charAt(i)){
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }
}
