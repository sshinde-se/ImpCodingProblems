package DynamicProgramming1;

import java.util.HashMap;
import java.util.Map;

/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    public static void main(String[] args){
        int n = 5;
        System.out.println(climbStairs(n));
        int n1 = 6;

        Map<Integer,Integer> memo = new HashMap<>();
        System.out.println(climbStairsUsingHashMap(n, memo));

        System.out.println(climbStairs(n1));
        System.out.println(climbStairsUsingHashMap(n1, memo));
    }

    private static int climbStairs(int n) {
        int one=1;
        int two = 1;
        for(int i=0;i<n-1;i++){
            int tmp = one;
            one = one + two;
            two = tmp;
        }
        return one;
    }
    private static int climbStairsUsingHashMap(int n, Map<Integer, Integer> memo) {
        if(n==0 || n==1)
            return 1;
        if(!memo.containsKey(n)){
            memo.put(n, climbStairsUsingHashMap(n-1, memo) + climbStairsUsingHashMap(n-2, memo));
        }
        return memo.get(n);
    }
}
