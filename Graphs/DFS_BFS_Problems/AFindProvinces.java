package Graphs.DFS_BFS_Problems;

import java.util.ArrayList;
/*
A province is a group of directly or indirectly connected cities and no other cities outside of
the group.
You are given an n x n matrix isConnected where isConnected[i][j] = 1
if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces

        1----2

          3

  In above ex 1 and 2 are connected so it is one province and 3 is another province hence count is 2.
 */
public class AFindProvinces {
    public static void main(String[] args){
        int[][] isConnected = {{1,1,0},
                               {1,1,0},
                               {0,0,1}};
        System.out.println("Provinces Using DFS recursion with adjacency list: "+ findCircleNum(isConnected));
        System.out.println("Provinces Using DFS recursion with adjacency matrix: "+ findCircleNumUsingMatrix(isConnected));
    }

    private static int findCircleNumUsingMatrix(int[][] isConnected) {
        int v = isConnected.length;
        boolean[] visited = new boolean[v];
        int cnt=0;
        for(int i=0;i<v;i++){
            if(!visited[i]){
                cnt++;
                DFSForMatrix(i, visited, isConnected);
            }
        }
        return cnt;
    }
    private static void DFSForMatrix(int v, boolean[] visited, int[][] isConnected){
        visited[v] = true;
        for(int i=0; i<isConnected.length; i++){
            if(!visited[i] && isConnected[v][i] == 1){
                DFSForMatrix(i, visited, isConnected);
            }
        }
    }

    public static int findCircleNum(int[][] isConnected) {
        int v=isConnected.length;
        boolean[] visited = new boolean[v];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<isConnected.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                if(isConnected[i][j] == 1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int cnt=0;
        for(int i=0;i<v;i++){
            if(!visited[i]){
                cnt++;
                DFS(i, visited, adj);
            }
        }
        return cnt;
    }
    public static void DFS(int v, boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        visited[v] = true;
        for(int i: adj.get(v)){
            if(!visited[i])
                DFS(i, visited, adj);
        }
    }
}
