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
        if(a.isEmpty())
            return -1;
        int j=0, res=0;
        if(a.charAt(0) == '-')
            j = 1;
        for(int i=j; i<a.length(); i++){
            if(Character.isDigit(a.charAt(i)))
                res = res * 10 + (a.charAt(i) - '0');
        }
        if(j==1)
            return res * -1;
        return res;
    }
}