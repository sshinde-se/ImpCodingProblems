package BinaryTree;

import java.util.*;

/*
The top view of a binary tree is the set of nodes visible when the tree is viewed from the top.
                  eye
        ------------------------
                   1
                 / | \
                2  |  3
                 \ |  |
                   4  |
                    \ |
                      5
                       \
                        6

    Here ans will be 2, 1, 3, 6 becoz (1,4) and (3,5) are n same line
 */
public class Z3TopViewOfBinaryTree {
    public static void main(String [] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);
        System.out.println(topViewOfTree(root));
    }
    static class Pair{
        Node next;
        int hd;
        public Pair(Node next, int hd){
            this.next = next;
            this.hd = hd;
        }
    }
    private static ArrayList<Integer> topViewOfTree(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()){
            Pair pair = queue.poll();
            int hd = pair.hd;
            Node tmp = pair.next;
            if(map.get(hd) == null)
                map.put(hd, tmp.data);
            if(tmp.left!=null){
                queue.add(new Pair(tmp.left, hd-1));
            }
            if(tmp.right!=null){
                queue.add(new Pair(tmp.right, hd+1));
            }
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }

    static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data = data;
        }
    }
}
