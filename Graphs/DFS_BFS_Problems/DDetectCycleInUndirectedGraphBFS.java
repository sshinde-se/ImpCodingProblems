package Graphs.DFS_BFS_Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*
Input:
V = 8, E = 6
    1---2    4---5      7
       /      \ /        \
      3        6          8
Output: true
Explanation: 4->5->6->4 is a cycle.

Time Complexity: O(N + 2E) + O(N), Where N = Nodes, 2E is for total degrees as we traverse all adjacent nodes. In the case of connected components of a graph, it will take another O(N) time.

Space Complexity: O(N) + O(N) ~ O(N), Space for queue data structure and visited array.
 */
public class DDetectCycleInUndirectedGraphBFS {
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList< >());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(1);

        System.out.println("Is cycle: "+ isCycle(4, adj));

    }
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(detect(i, visited, adj))
                    return true;
            }
        }
        return false;
    }
    public static boolean detect(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        visited[node] = true;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(node, -1));

        while(!q.isEmpty()){
            int curr = q.peek().first;
            int par = q.peek().second;
            q.poll();
            for(int it: adj.get(curr)){
                if(!visited[it]){
                    visited[it] = true;
                    q.add(new Node(it, curr));
                }
                else if(par != it)
                    return true;
            }
        }
        return false;
    }
    static class Node{
        int first;
        int second;
        public Node(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
}

