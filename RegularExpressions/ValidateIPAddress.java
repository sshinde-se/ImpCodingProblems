package RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
\d represents digits in regular expressions, same as [0-9]
\\d{1, 2} catches any one or two-digit number
(0|1)\\d{2} catches any three-digit number starting with 0 or 1.
2[0-4]\\d catches numbers between 200 and 249.
25[0-5] catches numbers between 250 and 255.
 */
public class ValidateIPAddress {
    public static void main(String[] args){
        String[] ip=new String[]{"000.12.12.034", "000.12.234.23.23", "121.234.12.12", "249.249.249.249","I.Am.not.an.ip"};
        for (String s : ip) {
            System.out.println(s + ": " + validateIpAddress(s));
        }
    }

    private static boolean validateIpAddress(String s) {
        if(s==null)
            return false;
        //String regex = "([0-9]|[0-9][0-9]|(0|1)[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        String regex = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
        String ip_regex = regex + "\\." + regex + "\\."+ regex + "\\."+  regex;
        Pattern pattern = Pattern.compile(ip_regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
