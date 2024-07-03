package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;


import static java.util.stream.Collectors.toList;

/*
For example, if we create an hourglass using the number 1 within an array full of zeros,
it may look like this:

        1 1 1 0 0 0
        0 1 0 0 0 0
        1 1 1 0 0 0
        0 0 0 0 0 0
        0 0 0 0 0 0
        0 0 0 0 0 0
Actually, there are many hourglasses in the array above. The three leftmost hourglasses are the following:

    1 1 1     1 1 0     1 0 0
      1         0         0
    1 1 1     1 1 0     1 0 0
The sum of an hourglass is the sum of all the numbers within it.
The sum for the hourglasses above are 7, 4, and 2, respectively.

In this problem you have to print the largest sum among all the hourglasses in the array.
 */
public class HourGlassProblem {
    public static void main(String[] args){
        List<List<Integer>> list = new ArrayList<>();
//        list.add(Arrays.asList(1, 1, 1, 0, 0, 0));
//        list.add(Arrays.asList(0, 1, 0, 0, 0, 0));
//        list.add(Arrays.asList(1, 1, 1, 0, 0, 0));
//        list.add(Arrays.asList(0, 0, 2, 4, 4, 0));
//        list.add(Arrays.asList(0, 0, 0, 2, 0, 0));
//        list.add(Arrays.asList(0, 0, 1, 2, 4, 0));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        IntStream.range(0, 6).forEach(i -> {
            try {
                list.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        System.out.println("Hour glass sum:" + hourGlassSum(list));
    }
    private static int hourGlassSum(List<List<Integer>> list){
        int res=Integer.MIN_VALUE;
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                int sum = list.get(i).get(j) + list.get(i).get(j+1) + list.get(i).get(j+2) +
                          list.get(i+1).get(j+1) +
                          list.get(i+2).get(j) + list.get(i+2).get(j+1) + list.get(i+2).get(j+2);
                if(sum>res)
                    res = sum;
            }
        }
        return res;
    }
}
