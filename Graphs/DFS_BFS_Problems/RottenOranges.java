package Graphs.DFS_BFS_Problems;

import java.util.LinkedList;
import java.util.Queue;
/*
You will be given an m x n grid, where each cell has the following values :
2  -  represents a rotten orange
1  -  represents a Fresh orange
0  -  represents an Empty Cell
Every minute, if a Fresh Orange is adjacent to a Rotten Orange in 4-direction(upward, downwards,
right, and left ) it becomes Rotten.
Return the minimum number of minutes required such that none of the cells has a Fresh Orange.
If it's not possible, return -1.

Time Complexity: O ( n x n ) x 4
Reason: Worst-case - We will be making each fresh orange rotten in the grid and for each
rotten orange will check in 4 directions

Space Complexity: O ( n x n )
Reason: worst-case -  If all oranges are Rotten, we will end up pushing all rotten oranges into
the Queue data structure
 */
public class RottenOranges {
    public static void main(String[] args){
        int[][] arr ={ {2,1,1} , {1,1,0} , {0,1,1} };
        int rotting = orangesRotting(arr);
        System.out.println("Minimum Number of Minutes Required "+rotting);
    }
    public static int orangesRotting(int[][] grid) {
        Queue<int[]> que = new LinkedList<>();
        int row=grid.length;
        int col = grid[0].length;
        int count_fresh = 0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 2){
                    que.offer(new int[]{i,j});
                }
                if(grid[i][j]==1)
                    count_fresh++;
            }
        }
        if(count_fresh==0)
            return 0;
        if(que.isEmpty())
            return -1;
        int minutes=-1;
        while(!que.isEmpty()){
            int size = que.size();
            while(size-->0){
                int[] cell = que.poll();
                int i = cell[0];
                int j = cell[1];
                if(i+1>=0 && i+1<row && j>=0 && j<col && grid[i+1][j] == 1){
                    grid[i+1][j] = 2;
                    count_fresh--;
                    que.offer(new int[]{i+1,j});
                }
                if(i-1>=0 && i-1<row && j>=0 && j<col && grid[i-1][j] == 1){
                    grid[i-1][j] = 2;
                    count_fresh--;
                    que.offer(new int[]{i-1,j});
                }
                if(i>=0 && i<row && j+1>=0 && j+1<col && grid[i][j+1] == 1){
                    grid[i][j+1] = 2;
                    count_fresh--;
                    que.offer(new int[]{i,j+1});
                }
                if(i>=0 && i<row && j-1>=0 && j-1<col && grid[i][j-1] == 1){
                    grid[i][j-1] = 2;
                    count_fresh--;
                    que.offer(new int[]{i,j-1});
                }
            }
            minutes++;
        }
        if(count_fresh==0)
            return minutes;
        return -1;
    }
}
