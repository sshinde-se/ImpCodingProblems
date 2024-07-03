package BinarySearchTree;

import java.util.Stack;

public class AValidBST {
    static boolean isValidBST(Node root){
        if(root==null)
            return true;
        if(root.left!=null && root.left.data> root.data)
            return false;
        if(root.right!=null && root.right.data< root.data)
            return false;
        if(!isValidBST(root.left) || !isValidBST(root.right))
            return false;
        return true;
    }
    static boolean isValidBSTUsingMinMax(Node root){
        return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    static boolean validBST(Node root, long min, long max){
        if(root==null)
            return true;
        if(root.data<=min || root.data>=max)
            return false;
        return validBST(root.left, min, root.data) && validBST(root.right, root.data, max);
    }

    static boolean validBSTUsingStack(Node root){
        Node prev = null;
        Stack<Node> stack =new Stack<>();
        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root= root.left;
            }
            root = stack.pop();
            if(prev!=null && prev.data >= root.data)
                return false;
            prev=root;
            root = root.right;
        }
        return true;
    }
    public static void main(String [] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        System.out.println(isValidBST(root));
        System.out.println(isValidBSTUsingMinMax(root));
        System.out.println(validBSTUsingStack(root));
    }
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
        }
    }
}
