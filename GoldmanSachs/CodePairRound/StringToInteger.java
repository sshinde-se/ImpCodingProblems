package GoldmanSachs.CodePairRound;

public class StringToInteger {
    public static void main(String[] args){
        String a = "123";
        String b = "-1344";
        String c = "123aab45";
        System.out.println("String to int: "+ atoi(a));
        System.out.println("String to int: "+ atoi(b));
        System.out.println("String to int: "+ atoi(c));
    }

    private static int atoi(String a) {
        String s = a.trim();
        if(s.isEmpty())
            return 0;
        int j=0, res=0;
        if(s.charAt(0) == '-')
            j = 1;
        for(int i=j; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i)))
            {
                if (res > (Integer.MAX_VALUE / 10) || (res == (Integer.MAX_VALUE / 10) && (s.charAt(i) - '0') > 7)){
                    return j==1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                res = res * 10 + (s.charAt(i) - '0');
            }

        }
        if(j==1)
            return res * -1;
        return res;
    }
}
