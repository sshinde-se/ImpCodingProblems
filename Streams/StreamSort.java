package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSort {
    public static void main(String[] args){
        List<Integer> l = Arrays.asList(1,5,10,15,20,25);
        System.out.println("Original List: " + l);

        //Sort in descending order
        l.stream().sorted((i1,i2) -> (i1<i2) ? 1 : (i1>i2 ? -1 : 0)).collect(Collectors.toList());

        l.stream().sorted((i1,i2) -> i2.compareTo(i1)).collect(Collectors.toList());

        List<Integer> l3 = l.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("Sorted list: "+ l3);

        sortStrings();

    }
    private static void sortStrings() {
        List<String> list = Arrays.asList("A","CAA", "AB", "AC", "ABAB", "ABB");
        System.out.println("List of strings:" + list);
        Comparator<String> c = (s1,s2) -> {
            if(s1.length() > s2.length())
                return 1;
            else if(s1.length() < s2.length())
                return -1;
            else return s1.compareTo(s2);
        };
        List<String> sortedList = list.stream().sorted(c).collect(Collectors.toList());
        System.out.println("Sorted List" + sortedList);
    }
}
