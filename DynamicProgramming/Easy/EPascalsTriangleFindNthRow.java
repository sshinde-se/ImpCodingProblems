package DynamicProgramming.Easy;
/*
                        1               1
                      1   1             2
                    1   2   1           3
                  1   3   3   1         4
                1   4   6   4   1       5
              1   5   10  10  5   1     6
 */
import java.util.ArrayList;
import java.util.List;
public class EPascalsTriangleFindNthRow {
    public static void main(String[] args){
        int row = 6;
        System.out.println(row + "th row in pascals triangle: " + findNthRowInPascalsTriangleBruteForce(row));
        System.out.println(row + "th row in pascals triangle optimal: " + findNthRowInPascalsTriangleUsingOptimal(row));
    }

    private static List<Integer> findNthRowInPascalsTriangleBruteForce(int row) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        for(int i=1;i<row;i++){
            list.add(nCr(row-1, i));
        }
        return list;
    }

    private static int nCr(int row, int col) {
        int res=1;
        for(int r=0;r<col;r++){
            /*
               n C r = n! / r! * (n-r)!
               7 C 3 = 7! / 3! * 4! = 7*6*5*4*3*2*1 / (3*2*1) * (4*3*2*1) => 7*6*5 / 3*2*1
               i.e denominator goes from 1 to col and numerator goes from row to row-col.
               which implies below formula
             */
            res = res * (row-r);
            res = res / (r+1);
        }
        return res;
    }
    private static List<Integer> findNthRowInPascalsTriangleUsingOptimal(int row){
        int res=1;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int col=1;col<row;col++){
            res = res * (row-col);
            res = res / col;
            list.add(res);
        }
        return list;
    }
}
