package Graphs.DFS_BFS_Problems;

import java.util.LinkedList;
import java.util.Queue;

/*
An image is represented by a 2-D array of integers, each integer representing the pixel value of the
image. Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill,
and a pixel value newColor, "flood fill" the image.
Input:
1 1 1
2 2 0
2 2 2
sr = 2, sc = 0, newColor = 3

Output:
1 1 1
3 3 0
3 3 3

Using DFS:
Time Complexity: O(NxM + NxMx4) ~ O(N x M)
For the worst case, all of the pixels will have the same colour,so DFS function will
be called for (N x M) nodes and for every node we are traversing for 4 neighbours, so it will take O(N x M x 4) time.

Space Complexity: O(N x M) + O(N x M)
O(N x M) for copied input array and recursive stack space takes up N x M locations at max.
 */
public class CFloodFill {
    public static void main(String[] args)
    {
        int[][] image =  {{1,1,1},
                          {1,1,0},
                          {1,0,1}};

        // sr = 1, sc = 1, newColor = 2
        int[][] ans = floodFill(image, 1, 1, 2);
        for (int[] an : ans) {
            for (int i : an)
                System.out.print(i + " ");
            System.out.println();
        }
        System.out.println();
        int[][] ans1 = floodFillUsingBFS(image, 1, 1, 2);
        for (int[] an : ans1) {
            for (int i : an)
                System.out.print(i + " ");
            System.out.println();
        }
    }

    private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] ans = image;
        int old_color = image[sr][sc];
        DFS(image, ans, sr, sc, newColor, old_color);
        return ans;
    }
    private static void DFS(int[][] image, int[][] ans, int sr, int sc, int newColor, int old_color){
        ans[sr][sc] = newColor;
        int row = image.length;
        int col = image[0].length;

        if(sr+1 >=0 && sr+1<row && sc>=0 && sc<col && image[sr+1][sc] == old_color && ans[sr+1][sc] != newColor){
            DFS(image, ans, sr+1, sc, newColor, old_color);
        }
        if(sr-1 >=0 && sr-1<row && sc>=0 && sc<col && image[sr-1][sc] == old_color && ans[sr-1][sc] != newColor){
            DFS(image, ans, sr-1, sc, newColor, old_color);
        }
        if(sr >=0 && sr<row && sc+1>=0 && sc+1<col && image[sr][sc+1] == old_color && ans[sr][sc+1] != newColor){
            DFS(image, ans, sr, sc+1, newColor, old_color);
        }
        if(sr >=0 && sr<row && sc-1>=0 && sc-1<col && image[sr][sc-1] == old_color && ans[sr][sc-1] != newColor){
            DFS(image, ans, sr, sc-1, newColor, old_color);
        }
    }
    public static int[][] floodFillUsingBFS(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color)
            return image;
        int old_color = image[sr][sc];
        int row=image.length;
        int col=image[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr,sc});
        image[sr][sc] = color;
        while(!q.isEmpty()){
            int n=q.size();
            while(n-->0){
                int[] cell = q.poll();
                int i=cell[0];
                int j=cell[1];
                if(i+1>=0 && i+1<row && j>=0 && j<col && image[i+1][j] == old_color){
                    image[i+1][j] = color;
                    q.offer(new int[]{i+1,j});
                }
                if(i-1>=0 && i-1<row && j>=0 && j<col && image[i-1][j] == old_color){
                    image[i-1][j] = color;
                    q.offer(new int[]{i-1,j});
                }
                if(i>=0 && i<row && j+1>=0 && j+1<col && image[i][j+1] == old_color){
                    image[i][j+1] = color;
                    q.offer(new int[]{i,j+1});
                }
                if(i>=0 && i<row && j-1>=0 && j-1<col && image[i][j-1] == old_color){
                    image[i][j-1] = color;
                    q.offer(new int[]{i,j-1});
                }
            }
        }
        return image;
    }
}
