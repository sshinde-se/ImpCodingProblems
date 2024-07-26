package Graphs.Traversals;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;
/*
DFS traversal is same like pre order traversal in tree. Uses Stack

Time Complexity: For an undirected graph, O(N) + O(2E), For a directed graph, O(N) + O(E),
Because for every node we are calling the recursive function once, the time taken is O(N)
and 2E is for total degrees as we traverse for all adjacent nodes.

Space Complexity: O(3N) ~ O(N), Space for dfs stack space, visited array and an adjacency list.
            1
           / \
          2---5
          |   |
          3---4

          DFS => 1 2 3 4 5

          0                         0 => {1,4}
         / \                        1 => {0,2,3}
        1   4   => 0 1 4 2 3        2 => {1}
       / \                          3 => {1}
      2   3                         4 => {0}
 */
public class GraphDFS {
    public static void main(String[] args){
        int V=5;
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

        ArrayList<Integer> ans = dfsOfGraph(V, adj);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+ " ");
        }
        System.out.println();
        ArrayList<Integer> ans1 = dfsWithoutRecursion(V, adj);
        for(int i: ans1){
            System.out.print(i+ " ");
        }
        System.out.println();
        Set<Integer> ans2 = dfsUsingStackWithLinkedHashSet(V, adj);
        for(int i: ans2){
            System.out.print(i+ " ");
        }
    }

    private static ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[v];
        ArrayList<Integer> ans = new ArrayList<>();
        DFS(0, visited, adj, ans);
        return ans;
    }
    private static void DFS(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans){
        visited[node] = true;
        ans.add(node);

        for(int i: adj.get(node)){
            if(!visited[i]){
                DFS(i, visited, adj, ans);
            }
        }
    }

    private static ArrayList<Integer> dfsWithoutRecursion(int v, ArrayList<ArrayList<Integer>> adj){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[v];
        ArrayList<Integer> list = new ArrayList<>();

        //replace with root node
        stack.push(0);

        while (!stack.isEmpty()){
            int node = stack.pop();
            if(!visited[node]){
                visited[node]= true;
                list.add(node);
                for(int i: adj.get(node)){
                    if(!visited[i])
                        stack.push(i);
                }
            }
        }
        return list;
    }

    public static Set<Integer> dfsUsingStackWithLinkedHashSet(int v, ArrayList<ArrayList<Integer>> adj){
        Set<Integer> visited = new LinkedHashSet<>();
        Stack<Integer> stack = new Stack<>();

        //replace with root node
        stack.push(0);

        while (!stack.isEmpty()){
            int node = stack.pop();

            if(!visited.contains(node)){
                visited.add(node);
                for(int i: adj.get(node)){
                    stack.push(i);
                }
            }
        }
        return visited;
    }
}
/*
DFS Using Recursion Output
In recursive DFS, the traversal order is determined by the order in which recursive calls are made.
The output for recursive DFS starting from vertex 0 would be:

Start at 0.
Go to 1 (first neighbor of 0).
From 1, go to 2 (first neighbor of 1).
Backtrack to 1, then go to 3 (next neighbor of 1).
Backtrack to 1, then backtrack to 0.
From 0, go to 4 (next neighbor of 0).

Output:
DFS using recursion starting from vertex 0:
0 1 2 3 4

DFS Using Stack Output
In stack-based DFS, the traversal order depends on the order in which neighbors are pushed onto
and popped from the stack. If neighbors are pushed in the order they appear in the adjacency list:

Start at 0.
Push 1 and 4 onto the stack (neighbors of 0).
Pop 4 (last neighbor of 0).
Pop 1 (next neighbor of 0).
From 1, push 2 and 3 onto the stack (neighbors of 1).
Pop 3 (last neighbor of 1).
Pop 2 (next neighbor of 1).

Output:
DFS using stack starting from vertex 0:
0 4 1 3 2

Summary
Recursive DFS: The order of visiting nodes follows the order of recursive calls, often depth-first.
Stack-based DFS: The order of visiting nodes follows the LIFO order of the stack, which can result
in different traversal orders depending on the push order of neighbors.
Both methods will visit all nodes reachable from the starting node but might do so in different orders. The provided example demonstrates these differences based on the same graph structure.
 */
