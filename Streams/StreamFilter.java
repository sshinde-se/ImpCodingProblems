package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilter {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1, 5, 10, 15, 20, 25, 30);
        System.out.println("Original List: " + l);

        List<Integer> l1 = l.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println("Filter elements with even elements in list: " + l1);
    }
}
