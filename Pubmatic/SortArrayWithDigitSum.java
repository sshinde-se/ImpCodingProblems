package Pubmatic;

import java.util.*;

public class SortArrayWithDigitSum {

    public static void main(String []args)
    {
        List<Integer> l = new ArrayList<>(Arrays.asList(4,9,43,401,45,101,401));

        System.out.println(sortArrayWithDigitSum(l));
        System.out.println(sortArrayWithDigitSumEfficient(l));
    }
    private static List<Integer> sortArrayWithDigitSum(List<Integer> l){

        Map<Integer, Integer> map = new TreeMap<>();

        for (int j : l) {
            if (map.containsKey(calculateDigitSum(j))) {
                map.put(calculateDigitSum(j), j);
            } else
                map.put(calculateDigitSum(j), j);
        }
        List<Integer> l1 = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            l1.add(entry.getValue());
        }
        return l1;
    }
    private static List<Integer> sortArrayWithDigitSumEfficient(List<Integer> l){
        l.sort(new Comparator<Integer>() {
            @Override
            public int compare(final Integer x, Integer y) {
                int tempx = x, tempy = y;
                int sumx = 0, sumy = 0;

                while (tempx != 0) {
                    sumx += tempx % 10;
                    tempx /= 10;
                }
                while (tempy != 0) {
                    sumy += tempy % 10;
                    tempy /= 10;
                }
                return sumx - sumy;
            }
        });

        return l;
    }
    private static Integer calculateDigitSum(int i)
    {
        int sum=0;
        while(i!=0){
            sum+=i%10;
            i=i/10;
        }
        return sum;
    }
    private static List<Integer> sortBySumOfDigits(List<Integer> l){
        l.sort((x, y)->{
            int tmpx=x;
            int tmpy=y;
            int sumx=0, sumy=0;
            while(tmpx!=0){
                sumx += tmpx%10;
                tmpx = tmpx/10;
            }
            while (tmpy!=0){
                sumy += tmpy%10;
                tmpy = tmpy/10;
            }
            return sumx - sumy;
        });
        return l;
    }
}

