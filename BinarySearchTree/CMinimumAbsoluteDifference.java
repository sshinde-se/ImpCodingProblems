package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CMinimumAbsoluteDifference {
    static int min = Integer.MAX_VALUE;
    static Node prev = null;
    static int minDiffUsingInorder(Node root){
        min = Integer.MAX_VALUE;
        inOrder(root);
        return min;
    }
    static void inOrder(Node root){
        if(root == null)
            return;
        inOrder(root.left);
        if(prev != null)
            min = Math.min(min, root.data - prev.data);
        prev = root;
        inOrder(root.right);
    }

    /*
    As we know inorder traversal of BST is in sorted order hence
    we can add it into arraylist and find min diff of list[i+1] - list[i]
     */
    static int minDiffUsingArrayList(Node root){
        int min = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        for(int i=0; i<list.size()-1; i++){
            min = Math.min(list.get(i+1)- list.get(i), min);
        }
        return min;
    }
    static void inOrder(Node root, List<Integer> list){
        if(root==null)
            return;
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }


    static int minDiffUsingStack(Node root){
        int min = Integer.MAX_VALUE;
        int prev = -1;
        Stack<Node> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev>=0)
                min = Math.min(min, root.data-prev);
            prev = root.data;
            root = root.right;
        }
        return min;
    }

    public static void main(String [] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(8);

        System.out.println(minDiffUsingInorder(root));
        System.out.println(minDiffUsingArrayList(root));
        System.out.println(minDiffUsingStack(root));
    }
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
        }
    }
}
