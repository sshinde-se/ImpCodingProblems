package ServiceNowCoding;

// Java program to find the longest palindromic substring in a given string.

class LongestPalindrome {
    static String longestPalin(String s) {
        // Initialize variables to keep track of the
        // longest palindrome and its length.
        int count = -1;
        String ans = "";

        // Get the length of the input string.
        int n = s.length();

        // Create a boolean 2D array to store palindrome information.
        boolean[][] dp = new boolean[n][n];

        // Iterate through different substring lengths.
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                // Check if the substring is of length 1 (base case).
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    // Check if the substring is of length 2 (base case).
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    // Check if the current substring is a
                    // palindrome based on its ends.
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }

                // Update the longest palindrome and its length if found.
                if (dp[i][j] && count < s.substring(i, j + 1).length()) {
                    ans = s.substring(i, j + 1);
                    count = ans.length();
                }
            }
        }
        return ans;
    }
    static int longestPalSubstr(String str)
    {
        int n = str.length(); // calculating size of string
        if (n < 2)
            return n; // if string is empty then size will be 0.
        // if n==1 then, answer will be 1(single
        // character will always palindrome)

        int maxLength = 1,start=0;
        int low, high;
        for (int i = 0; i < n; i++) {
            low = i - 1;
            high = i + 1;
            while ( high < n && str.charAt(high) == str.charAt(i)) //increment 'high'
                high++;

            while ( low >= 0 && str.charAt(low) == str.charAt(i)) // decrement 'low'
                low--;

            while (low >= 0 && high < n && str.charAt(low) == str.charAt(high) ){
                low--;
                high++;
            }

            int length = high - low - 1;
            if (maxLength < length){
                maxLength = length;
                start=low+1;
            }
        }
        System.out.print("Longest palindrome substring is: ");
        System.out.println(str.substring(start, start + maxLength ));
        return maxLength;

    }
    public static void main(String[] args) {
        // Input string
        String str = "forgeeksskeegfor";

        // Print the longest palindromic substring.
        System.out.println(longestPalin(str));
        System.out.println(longestPalSubstr(str));
    }
}

