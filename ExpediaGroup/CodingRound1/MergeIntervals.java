package ExpediaGroup.CodingRound1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;

/*
Given collection of intervals
return overlapping intervals sorted in ascending order

e.g
intervals= [[7,7],[2,3],[6,11],[1,2]]

output:
6 11  //[7,7] can be included in [6,11]
1 3   //[1,2] and [2,3] and be converted as [1,3]

 */
public class MergeIntervals {
    public static void main(String[] args){
        List<List<Integer>> intervals = new ArrayList<>();
        intervals.add(Arrays.asList(7,7));
        intervals.add(Arrays.asList(2,3));
        intervals.add(Arrays.asList(6,11));
        intervals.add(Arrays.asList(1,2));
        intervals.add(Arrays.asList(4,5));

        System.out.println(intervals);
        System.out.println(mergeIntervals(intervals));

        List<List<Integer>> intervals1 = new ArrayList<>();
        intervals1.add(Arrays.asList(1,3));
        intervals1.add(Arrays.asList(2,6));
        intervals1.add(Arrays.asList(8,10));
        intervals1.add(Arrays.asList(15,18));
        System.out.println(intervals1);
        System.out.println(mergeIntervals(intervals1));

        int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        int[][] res = mergeOverlappingIntervals(arr);
        for (int[] re : res) {
            for (int j = 0; j < res.length; j++) {
                System.out.print(re[j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] mergeOverlappingIntervals(int[][] arr) {
        Arrays.sort(arr, (o1, o2) ->{
            return o1[0] - o2[0];
        });
        List<List<Integer>> list = new ArrayList<>();
        for (int i=0;i<arr.length;i++){
            int start=arr[i][0];
            int end = arr[i][1];
            if(!list.isEmpty() && end <= list.get(list.size()-1).get(1))
                continue;
            for (int j=i+1;j<arr.length;j++){
                if(arr[j][0] < end)
                    end = Math.max(end, arr[j][1]);
                else
                    break;
            }
            list.add(Arrays.asList(start,end));
        }
        int[][] res = new int[list.size()][];
        int[] tmp = new int[0];
        for(int i=0;i< list.size();i++){
            //res[i] = list.get(i).toArray();
        }
        return list.toArray(new int[list.size()][]);
    }

    private static List<List<Integer>> mergeIntervals(List<List<Integer>> intervals) {
        intervals.sort((o1, o2) -> {
            if(o1.get(0) > o2.get(0))
                return 1;
            else if (o1.get(0) < o2.get(0))
                return -1;
            return 0;
        });
        System.out.println(intervals);
        List<List<Integer>> newList = new ArrayList<>();
        int i=0;
        for(i=0;i+1< intervals.size();i++){
            if(intervals.get(i).get(1) >= intervals.get(i+1).get(0)){
                newList.add(Arrays.asList(intervals.get(i).get(0), intervals.get(i+1).get(1)));
                i=i+1;
            }
            else
                newList.add(intervals.get(i));
        }
        if(i<intervals.size())
            newList.add(intervals.get(i));

        return newList;
    }


}
