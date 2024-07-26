package DynamicProgramming.Easy;

import java.util.ArrayList;
import java.util.List;

public class FPascalsTrianglePrintAllElements {
    public static void main(String[] args){
        int row = 6;
        System.out.println(row + "th row in pascals triangle: " + printAllRowsPascalsTriangleBruteForce(row));
        System.out.println(row + "th row in pascals triangle optimal: " + printAllRowsPascalsTriangleOptimal(row));
    }

    private static List<List<Integer>> printAllRowsPascalsTriangleOptimal(int row) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int n=1;n<=row;n++){
            ans.add(generateRows(n));
        }
        return ans;
    }

    private static List<Integer> generateRows(int n) {
        int res=1;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int col=1;col<n;col++){
            res = res * (n-col);
            res = res / col;
            list.add(res);
        }
        return list;
    }

    private static List<List<Integer>> printAllRowsPascalsTriangleBruteForce(int row) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int n=0;n<row;n++){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for(int r=1;r<=n;r++){
                list.add(nCr(n,r));
            }
            ans.add(list);
        }
        return ans;
    }
    private static int nCr(int row, int col){
        int res=1;
        for(int r=0;r<col;r++){
            res = res * (row-r);
            res = res / (r+1);
        }
        return res;
    }
}
