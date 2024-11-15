package DynamicProgramming.Easy;

import java.util.HashMap;
import java.util.Map;

/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class AClimbingStairs {
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
        int prev2 = 1;
        int prev = 1;
        for(int i=2;i<=n;i++){
            int curri = prev2 + prev;
            prev2 = prev;
            prev = curri;
        }
        return prev;
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
