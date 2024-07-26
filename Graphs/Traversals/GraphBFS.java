package Graphs.Traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
BFS traversal is same like level order traversal in tree. Uses Queue
            1
           / \
          2---5
          |   |
          3---4

          BFS => 1 2 5 3 4

          0                         0 => {1,4}
         / \                        1 => {0,2,3}
        1   4   => 0 1 4 2 3        2 => {1}
       / \                          3 => {1}
      2   3                         4 => {0}
 */
public class GraphBFS {
    public static void main(String[] args){
        int V= 5,E=4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);

        ArrayList<Integer> ans = bfsOfGraph(V, adj);
        for (Integer an : ans) {
            System.out.print(an + " ");
        }
    }

    private static ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[v];
        //By declaring the variable type as an interface(Queue), you can change the
        //underlying implementation easily without modifying the code that uses the interface.
        Queue<Integer> queue = new LinkedList<>();
        //Assuming node starts at 0 update root node accordingly
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()){
            int node = queue.poll();
            bfs.add(node);

            for(int i: adj.get(node)){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        return bfs;
    }
}
