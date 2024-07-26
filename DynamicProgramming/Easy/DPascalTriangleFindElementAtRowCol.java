package DynamicProgramming.Easy;
/*
                        1               1
                      1   1             2
                    1   2   1           3
                  1   3   3   1         4
                1   4   6   4   1       5
              1   5   10  10  5   1     6
 */
public class DPascalTriangleFindElementAtRowCol {
    public static void main(String[] args){
        int row = 5;
        int col = 3;
        System.out.println("Row: "+ row + ",Col: "+ col+ ". Element at that location: " + findElementInPascalsTriangleBruteForce(row,col));
        System.out.println("Row: "+ row + ",Col: "+ col+ ". Element at that location using dp: " + findElementInPascalsTriangleOptimal(row-1,col-1));

    }

    private static int findElementInPascalsTriangleBruteForce(int row, int col) {
        int n= fact(row-1);
        int r= fact(col-1);
        int nMinusr = fact((row-1)-(col-1));
        int ans = r * nMinusr;
        ans = n / ans;
        return ans;
    }

    private static int fact(int i) {
        if(i==0)
            return 1;
        return i * fact(i-1);
    }

    private static int findElementInPascalsTriangleOptimal(int row, int col){
        int res = 1;
        for(int r=0; r<col;r++){
            res = res * (row - r);
            res = res / (r + 1);
        }
        return res;
    }
}
