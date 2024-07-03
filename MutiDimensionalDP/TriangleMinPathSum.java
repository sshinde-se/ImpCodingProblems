package MutiDimensionalDP;

import java.util.ArrayList;
import java.util.List;

public class TriangleMinPathSum {
    public static void main(String[] args){
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        a.add(2);
        List<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(4);
        List<Integer> c = new ArrayList<>();
        c.add(6);
        c.add(5);
        c.add(7);
        List<Integer> d = new ArrayList<>();
        d.add(4);
        d.add(1);
        d.add(8);
        d.add(3);

        triangle.add(a);
        triangle.add(b);
        triangle.add(c);
        triangle.add(d);

        System.out.println(minPathSum(triangle));
    }

    private static int minPathSum(List<List<Integer>> triangle) {
        int l = triangle.size();
        int[] dp = new int[l+1];
        for(int row=l-1; row>-1; row--){
            for(int col=0; col<row+1; col++){
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col+1]);
            }
        }
        return dp[0];
    }
}
