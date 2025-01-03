package Common; /******************************************************************************


sort HashMap using values

*******************************************************************************/

public class ConvertRomanToDecimal
{
	public static void main(String[] args) {
        ConvertRomanToDecimal ob = new ConvertRomanToDecimal();
 
        // Considering inputs given are valid
        String str = "MCMVII";
        System.out.println("Integer form of Roman Numeral"
                           + " is "
                           + ob.romanToDecimal(str));
	}
	
	int value(char r)
    {
        // if (r == 'I')
        //     return 1;
        // if (r == 'V')
        //     return 5;
        // if (r == 'X')
        //     return 10;
        // if (r == 'L')
        //     return 50;
        // if (r == 'C')
        //     return 100;
        // if (r == 'D')
        //     return 500;
        // if (r == 'M')
        //     return 1000;
        int x=-1;
        switch(r){
            case 'I':
                x = 1;
                break;
            case 'V':
                x = 5;
                break;
            case 'X':
                x = 10;
                break;
            case 'L':
                x = 50;
                break;
            case 'C':
                x = 100;
                break;
            case 'D':
                x = 500;
                break;
            case 'M':
                x = 1000;
                break;
        }
        return x;
    }
 
    // Finds decimal value of a
    // given roman numeral
    int romanToDecimal(String str)
    {
        // Initialize result
        int res = 0;
 
        for (int i = 0; i < str.length(); i++) {
            // Getting value of symbol s[i]
            int s1 = value(str.charAt(i));
 
            // Getting value of symbol s[i+1]
            if (i + 1 < str.length()) {
                int s2 = value(str.charAt(i + 1));
 
                // Comparing both values
                if (s1 >= s2) {
                    // Value of current symbol
                    // is greater or equalto
                    // the next symbol
                    res = res + s1;
                }
                else {
                    // Value of current symbol is
                    // less than the next symbol
                    res = res + s2 - s1;
                    i++;
                }
            }
            else {
                res = res + s1;
            }
        }
 
        return res;
    }

}
