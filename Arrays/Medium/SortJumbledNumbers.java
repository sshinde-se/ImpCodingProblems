package Arrays.Medium;

import java.util.*;
/*
You are given a 0-indexed integer array mapping which represents the mapping rule of a shuffled
decimal system. mapping[i] = j means digit i should be mapped to digit j in this system.

The mapped value of an integer is the new integer obtained by replacing each occurrence of digit i
in the integer with mapping[i] for all 0 <= i <= 9.

You are also given another integer array nums. Return the array nums sorted in non-decreasing order
based on the mapped values of its elements.

Notes:
Elements with the same mapped values should appear in the same relative order as in the input.
The elements of nums should only be sorted based on their mapped values and not be replaced by them.

Input: mapping = [8,9,4,0,2,1,3,5,7,6], nums = [991,338,38]
Output: [338,38,991]
Explanation:
Map the number 991 as follows:
1. mapping[9] = 6, so all occurrences of the digit 9 will become 6.
2. mapping[1] = 9, so all occurrences of the digit 1 will become 9.
Therefore, the mapped value of 991 is 669.
338 maps to 007, or 7 after removing the leading zeros.
38 maps to 07, which is also 7 after removing leading zeros.
Since 338 and 38 share the same mapped value, they should remain in the same relative order, so 338 comes before 38.
Thus, the sorted array is [338,38,991].
 */
public class SortJumbledNumbers {
    public static void main(String[] args){
        int[] mapping= {9,8,7,6,5,4,3,2,1,0};
        int[] nums= {0,1,2,3,4,5,6,7,8,9,9};

        System.out.println("Sorted Mapping Numbers: " + Arrays.toString(sortJumbledNumbersMySol(mapping, nums)));
        System.out.println("Sorted Mapping Numbers: " + Arrays.toString(sortJumbledArray(mapping, nums)));
    }

    private static int[] sortJumbledNumbersMySol(int[] mapping, int[] nums) {
        int[] ans=new int[nums.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            if(!map.containsKey(i)){
                map.put(i, calNewNumber(i,mapping));
            }
        }
        List<Map.Entry<Integer,Integer>> l = new LinkedList<>(map.entrySet());
        l.sort((i1,i2)-> i1.getValue().compareTo(i2.getValue()));

        HashMap<Integer,Integer> hmap = new LinkedHashMap<>();
        for(Map.Entry<Integer,Integer> entry: l){
            hmap.put(entry.getKey(),entry.getValue());
        }
        int i=0;
        for(Map.Entry<Integer,Integer> entry: hmap.entrySet()){
            ans[i] = entry.getKey();
            i++;
        }
        return ans;
    }

    private static int calNewNumber(int n, int[] mapping) {
        int res=0,cnt=0;
        if(n==0)
            return mapping[0];
        while(n!=0){
            int digit = n%10;
            res = mapping[digit] * (int)Math.pow(10,cnt) + res;
            n=n/10;
            cnt++;
        }
        return res;
    }
    private static int[] sortJumbledArray(int[] mapping,int[] nums){
        Map<Integer, Integer> numberMapping = new HashMap<>();

        for (int num : nums) {
            if (!numberMapping.containsKey(num)) {
                numberMapping.put(num, calNewNumber(num, mapping));
            }
        }

        Integer[] numsBoxed = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numsBoxed, (a, b) -> Integer.compare(numberMapping.get(a), numberMapping.get(b)));

        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsBoxed[i];
        }

        return nums;
    }
}
