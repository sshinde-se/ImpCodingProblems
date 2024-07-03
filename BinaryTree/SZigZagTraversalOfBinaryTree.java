package BinaryTree;

import java.util.*;

public class SZigZagTraversalOfBinaryTree {
    static List<List<Integer>> zigZagTraversal(Node root){
        List<List<Integer>> list = new ArrayList<>();
        list = levelOrder(root, 0, list);
        for(int i=0; i<list.size(); i++){
            if(!(i%2 == 0))
                Collections.reverse(list.get(i));
        }
        return list;
    }
    static List<List<Integer>> levelOrder(Node root, int level, List<List<Integer>> al){
        if(root == null)
            return al;
        if(al.size()== level){
            List<Integer> l1=new ArrayList<>();
            l1.add(root.data);
            al.add(l1);
        }
        else
            al.get(level).add(root.data);
        levelOrder(root.left, level+1, al);
        levelOrder(root.right, level+1, al);
        return al;
    }
    static List<List<Integer>> zigZagTraversalUsingQueue(Node root){
        List<List<Integer>> list = new ArrayList<>();
        if(root==null)
            return list;
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int n=que.size();
            List<Integer> l1=new ArrayList<>();
            for(int i=0;i<n;i++){
                Node tmp=que.poll();
                l1.add(tmp.data);
                if(tmp.left!=null)
                    que.add(tmp.left);
                if(tmp.right!=null)
                    que.add(tmp.right);
            }
            list.add(l1);
        }
        for(int i=0;i<list.size();i++){
            if(!(i%2==0)){
                Collections.reverse(list.get(i));
            }
        }
        return list;
    }
    public static void main(String [] args) {
        Node root;
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(zigZagTraversal(root));
        System.out.println(zigZagTraversalUsingQueue(root));
    }
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
        }
    }
}
