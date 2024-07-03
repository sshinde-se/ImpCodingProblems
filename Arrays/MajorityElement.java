package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// This will return majority element which means
// the element that appears more than n / 2 times in the array.
public class MajorityElement {
    public static int  majorityElement(int [] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    public static int  majorityElementUsingHashMap(int [] nums){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int num: nums){
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        
        System.out.println(hashMap);
        int n= nums.length/2;
        for(Map.Entry<Integer, Integer> map: hashMap.entrySet()){
            if(map.getValue() > n){
                return map.getKey();
            }
        }
        return 0;
    }
    public static int majorityElement3(int[] nums) {
        int cnt=nums.length/2;
        int element=0;
        if(nums.length==1 && nums[0] == 0)
            return 1;
        for(int i=0; i<nums.length; i++){
            int size=0;
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] == nums[j])
                    size++;
            }
            if(size>cnt)
                element = nums[i];
            if(size == cnt)
                element = nums[i];
        }
        return element;
    }
    public static void main(String [] args){
        int []nums = new int[]{2,2,1,1,1,2,2};
        System.out.println("majority element: "+ majorityElement(nums));
        System.out.println("majority element: "+ majorityElementUsingHashMap(nums));
        System.out.println("majority element: "+ majorityElement3(nums));
    }
}
