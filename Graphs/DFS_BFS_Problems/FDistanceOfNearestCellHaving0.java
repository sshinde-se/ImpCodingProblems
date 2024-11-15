package Graphs.DFS_BFS_Problems;

import java.util.LinkedList;
import java.util.Queue;

/*
Problem Statement: Given a binary grid of N*M.
Find the distance of the nearest 0 in the grid for each cell.
https://www.youtube.com/watch?v=edXdVwkYHF8&t=1202s

Input:
[0,0,0]
[0,1,0]
[1,1,1]

Output:
[0,0,0]
[0,1,0]
[1,2,1]
 */
public class FDistanceOfNearestCellHaving0 {
    public static void main(String[] args)
    {
        int[][] grid = {{0,0,0},
                        {0,1,0},
                        {1,1,1}};
        int[][] ans = nearest(grid);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
        int[][] ans1 = nearestByUsingDP(grid);
        for(int i = 0; i < ans1.length; i++){
            for(int j = 0; j < ans1[i].length; j++){
                System.out.print(ans1[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] nearestByUsingDP(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int inf = 1000_000;

        int[][] dist = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    int up = (i>0) ? dist[i-1][j] : inf;
                    int left = (j>0) ? dist[i][j-1] : inf;
                    dist[i][j] = Math.min(up, left) + 1;
                }
            }
        }
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(grid[i][j] == 1){
                    int down = (i<m-1) ? dist[i+1][j] : inf;
                    int right = (j<n-1) ? dist[i][j+1] : inf;
                    dist[i][j] = Math.min(dist[i][j], Math.min(down, right) + 1);
                }
            }
        }
        return dist;
    }
    public static int[][] nearest(int[][] grid){
        int row=grid.length;
        int col=grid[0].length;
        int[][] visited = new int[row][col];
        int[][] dist=new int[row][col];
        Queue<Node> q=new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==0){
                    q.add(new Node(i,j,0));
                    visited[i][j] = 1;
                }
                else{
                    visited[i][j] = 0;
                }
            }
        }
        while(!q.isEmpty()){
            int i = q.peek().first;
            int j = q.peek().second;
            int steps = q.peek().third;
            dist[i][j] = steps;
            q.remove();
            if(i+1>=0 && i+1<row && j>=0 && j<col && visited[i+1][j] == 0){
                visited[i+1][j] = 1;
                q.add(new Node(i+1, j, steps+1));
            }
            if(i-1>=0 && i-1<row && j>=0 && j<col && visited[i-1][j] == 0){
                visited[i-1][j] = 1;
                q.add(new Node(i-1, j, steps+1));
            }
            if(i>=0 && i<row && j+1>=0 && j+1<col && visited[i][j+1] == 0){
                visited[i][j+1] = 1;
                q.add(new Node(i, j+1, steps+1));
            }
            if(i>=0 && i<row && j-1>=0 && j-1<col && visited[i][j-1] == 0){
                visited[i][j-1] = 1;
                q.add(new Node(i, j-1, steps+1));
            }
        }
        return dist;
    }
    static class Node{
        int first;
        int second;
        int third;
        public Node(int f, int s, int t){
            this.first=f;
            this.second=s;
            this.third=t;
        }
    }
}
