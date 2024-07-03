package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FLevelOrderTraversalUsingArrayList {
    static List<List<Integer>> levelOrderTraversal(Node root){
        List<List<Integer>> list = new ArrayList<>();
        levelOrder(root, 0, list);
        return list;
    }
    static void levelOrder(Node root, int level, List<List<Integer>> al){
        if(root==null)
            return;
        if(al.size() == level){
            List<Integer> l1=new ArrayList<>();
            l1.add(root.data);
            al.add(l1);
        }
        else 
            al.get(level).add(root.data);
        levelOrder(root.left, level+1, al);
        levelOrder(root.right, level+1, al);
    }
    static List<List<Integer>> levelOrderUsingQueue(Node root){
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

        System.out.println(levelOrderTraversal(root));
        System.out.println(levelOrderUsingQueue(root));
    }
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
        }
    }
}
