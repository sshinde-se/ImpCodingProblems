package TwoDMatrix.Medium;

public class AFindMatrixWithRowSumAndColSum {
    public static void main(String[] args){
        int[] rowSum = {5,7,10};
        int[] colSum = {8,6,8};
        System.out.println("Find Matrix: ");
        int[][] res = findMatrixWithRowSumColSum(rowSum, colSum);
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[0].length;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int[][] findMatrixWithRowSumColSum(int[] rowSum, int[] colSum) {
        int rowLength = rowSum.length;
        int colLength = colSum.length;
        int i=0,j=0;

        int[][] res = new int[rowLength][colLength];
        while (i<rowLength && j<colLength){
            int val = Math.min(rowSum[i], colSum[j]);
            rowSum[i] = rowSum[i] - val;
            colSum[j] = colSum[j] - val;

            res[i][j] = val;

            if(rowSum[i]==0)
                i++;
            if(colSum[j]==0)
                j++;
        }
        return res;
    }
}
