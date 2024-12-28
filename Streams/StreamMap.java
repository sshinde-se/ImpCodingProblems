package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMap {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1, 5, 10, 15, 20, 25);
        System.out.println("Original List: " + l);

        List<Integer> l2 = l.stream().map(i -> i + 5).collect(Collectors.toList());
        System.out.println("Apply certain operation on every element of list: " + l2);
    }
}
