package RegularExpressions;
/*
The username consists of  to  characters inclusive.
If the username consists of less than  or greater than  characters, then it is an invalid username.
The username can only contain alphanumeric characters and underscores (_).
Alphanumeric characters describe the character set consisting of lowercase characters ,
uppercase characters , and digits .
 */
public class ValidateUsername {
    public static void main(String[] args){
        String[] usernames = new String[]{"W@Vs6$WlXb", "dzTDT_qtnZs7JCozw4barzxFu0dSk80O", "hbOoWFcvDbCUvDDL222wY0wOoc9gwozWjkzFi7VV5J0SNT18ESCLKnzhRtLH3edUaH", "SMG2UNYKuuZoeaiaKdjd", "Julia", "Sanju_1234"};
        for (String s: usernames){
            System.out.println(s+" : "+ (validateUsername(s) ? "Valid": "Invalid"));
        }
    }

    private static boolean validateUsername(String s) {
        String regex = "[a-zA-Z]\\w{7,29}";

        return s.matches(regex);
    }
}
