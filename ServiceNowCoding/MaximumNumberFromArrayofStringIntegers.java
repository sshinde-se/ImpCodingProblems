package ServiceNowCoding;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaximumNumberFromArrayofStringIntegers {
    public static void main(String[] args){
        String[] arr = new String[]{"54", "546", "548", "60"};
        List<String> l = Arrays.asList(arr);
        System.out.println(maxNumberFromArray(l));
        String[] arr1 = new String[]{"1", "34", "3", "98", "9", "76", "45", "4"};
        List<String> l1 = Arrays.asList(arr1);
        System.out.println(maxNumberFromArray(l1));
    }

    private static String maxNumberFromArray(List<String> arr) {
        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String xy = o1.concat(o2);
                String yx = o2.concat(o1);

                int x = Integer.parseInt(xy);
                int y = Integer.parseInt(yx);

                if(x>y)
                    return 1;
                else if (x<y)
                    return -1;
                else
                    return 0;
            }
        }.reversed());
        System.out.println(arr);
        StringBuilder s1 = new StringBuilder();
        for(String s: arr){
            s1.append(s);
        }
        return s1.toString();
    }
}
