package RegularExpressions;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
Groups in regular expressions are created using parentheses () and can be referenced by their index.
Group 0 always refers to the entire match, while subsequent groups are numbered from 1
onward based on the order of their opening parentheses.

Groups are defined in the regex pattern using parentheses:
Capturing Group: (pattern) captures the matched substring for later reference.
Non-Capturing Group: (?:pattern) groups the pattern without capturing it.

Regex Pattern
Suppose you want to extract the day, month, and year from a date string in the format "dd-MM-yyyy".

String regex = "(\\d{2})-(\\d{2})-(\\d{4})";
Group 1: Captures the day.
Group 2: Captures the month.
Group 3: Captures the year.

Finding Matches:

if (matcher.find()) -> checks if the matcher finds a subsequence that matches the pattern.
matcher.group(0) returns the entire matched substring.
matcher.group(1), matcher.group(2), and matcher.group(3) return the matched substrings for the respective capturing groups.

Group Numbering
Group 0: Always refers to the entire match.
Group 1: The first capturing group, i.e., the first set of parentheses.
Group 2: The second capturing group, i.e., the second set of parentheses, and so on.

 */
public class RemoveDuplicateWords {
    public static void main(String[] args){
        String[] strings = new String[]{"Good bye bye world world","Ram went went to to to his home","Hello hello world world"};
        for(String s: strings){
            System.out.println(s + " converted to : " + removeDuplicateWords(s));
            System.out.println(s + " converted to : " + removeDuplicateWordsUsingHashSet(s));
        }
    }

    private static String removeDuplicateWords(String s) {
        String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
        /*
        \\b  => matches any word boundary (this would include spaces, dashes, commas, semi-colons, etc.
        \\w+ => A word character: [a-zA-Z_0-9] (+ means one or more, * means zero or more)
        ?    => This symbol tells the computer that the preceding character may or may not be present in the string to be matched.
        ?:   => preceding item is optional and matched at most once(i.e occurs 0 or 1 times or optional)
               ?: is used to create a non-capturing group. A non-capturing group groups part of the regex together without
                creating a backreference for the matched group.
        \\W+ => This matches one or more non-word characters (anything that is not a word character).
        \\1  => This is a back reference to the first capturing group (\\w+).
                It ensures that the same word that was captured earlier is repeated. The \\1 references the exact text captured by the first capturing group.
        \\b  => Another word boundary anchor to ensure that the repeated word is a whole word.
        +    => This quantifier ensures that the non-capturing group (?:\\W+\\1\\b) matches one or more times, effectively matching one or more repeated words.
         */
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            s = s.replaceAll(matcher.group(), matcher.group(1));
        }
        return s;
    }

    private static String removeDuplicateWordsUsingHashSet(String s) {
        String[] strings = s.split(" ");
        Set<String> stringSet = new LinkedHashSet<>();
        Collections.addAll(stringSet, strings);
        String res= "";
        for (String s1:stringSet){
            if(res.equals(""))
                res = res+s1;
            else
                res = res + " " + s1;
        }
        return res;
    }
}
