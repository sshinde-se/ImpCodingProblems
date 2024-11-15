package Graphs.DFS_BFS_Problems;

import java.util.ArrayList;

/*
Input:
V = 8, E = 6
    1---2    4---5      7
       /      \ /        \
      3        6          8
Output: true
Explanation: 4->5->6->4 is a cycle.

Time Complexity: O(N + 2E) + O(N), Where N = Nodes, 2E is for total degrees as we traverse all adjacent nodes. In the case of connected components of a graph, it will take another O(N) time.

Space Complexity: O(N) + O(N) ~ O(N), Space for recursive stack space and visited array.
 */
public class EDetectCycleInUndirectedGraphDFS {
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList< >());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        System.out.println("Is cycle: "+ isCycle(4, adj));

    }
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(DFS(i, -1, visited, adj))
                    return true;
            }
        }
        return false;
    }
    public static boolean DFS(int node, int parent,boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        visited[node] = true;
        for(int it: adj.get(node)){
            if(!visited[it]){
                if(DFS(it, node, visited, adj))
                    return true;
            }
            else if(parent != it)
                return true;
        }
        return false;
    }

}

