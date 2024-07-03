package RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor {
    public static void main(String[] args){
        String[] tags = new String[]{"<h1>Nayeem loves counseling</h1>",
                "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>",
                "<Amee>safat codes like a ninja</amee>",
                "<SA premium>Imtiaz has a secret crush</SA premium>"};
        for (String s: tags){
            System.out.println(s + " : "+ tagsContentExtractor(s));
        }
    }

    private static String tagsContentExtractor(String s) {
        String regex = "<(.+)>([^<>]+)</\\1>";
        /*
        <(.+)> => it signifies tag start and end <> and it contains one or more character
        [^<>]  => it signifies tag content does not include <> , i.e other than < & > any char is included
        </\\1> => ending tag match the already captured word

         */
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        String res="";
        if(!matcher.find()){
            return "None";
        }
        else {
            res = matcher.group(2);
            while (matcher.find()){
                res = res + " "+ matcher.group(2);
            }
        }
        return res;
    }
}
