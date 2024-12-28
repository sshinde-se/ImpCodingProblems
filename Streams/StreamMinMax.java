package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMinMax {
    public static void main(String[] args){
        List<Integer> l = Arrays.asList(1,5,10,15,20,25);
        System.out.println("Original List: " + l);

        Integer i = l.stream().min((i1,i2) -> i1.compareTo(i2)).get();
        System.out.println(i);
    }
}
