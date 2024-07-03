package ExpediaGroup.CodingRound2;

import java.util.Scanner;


/**

 Given an m x n matrix of characters and a string, return true if that string exists in the grid.
 The string can be created from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighbouring.

 Mat = Mat = {{'A','B','C','E'},
 {'S','F','C','S'},
 {'A','D','E','E'}}

 S = "ABCCED"

 ADFBCD

 **/
public class CheckStringExistInGrid {
    static String s = "ADFBCD";

    static boolean checkValidString(char[][] mat){
        int row= mat.length;
        int col= mat[0].length;
        int l=s.length();
        char[] ch = s.toCharArray();
        int k=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;i++){
                if(mat[i][j]==ch[k])
                    return DFS(mat, i, j, k+1);

            }
        }
        return false;
    }
    static boolean DFS(char[][] mat, int i, int j, int k){
        int row= mat.length;
        int col= mat[0].length;

        if(i<0 || j<0 || i>=row || j>=col){
            return false;
        }
        if(mat[i][j] == s.charAt(k)){
            DFS(mat, i+1, j, k+1);
            DFS(mat, i, j+1, k+1);
            DFS(mat, i-1, j, k+1);
            DFS(mat, i, j-1, k+1);
        }
        return true;
    }

    public static void main(String[] args){
        char[][] mat = {{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};

        System.out.println(checkValidString(mat));
    }
}


