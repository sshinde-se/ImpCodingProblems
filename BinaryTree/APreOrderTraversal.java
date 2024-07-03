package BinaryTree;

import java.util.Stack;

public class APreOrderTraversal {
    static void preOrderTraversal(Node root){
        Stack<Node> stack = new Stack<>();
        while(true){
            while(root != null){
                stack.push(root);
                System.out.print(root.data + " ");
                root = root.left;
            }
            if(stack.isEmpty())
                break;
            root = stack.pop();
            root = root.right;
        }
    }
    static void preOrderTraversalRecursion(Node root){
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderTraversalRecursion(root.left);
            preOrderTraversalRecursion(root.right);
        }
    }
    public static void main(String [] args) {
        Node root=null;
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        preOrderTraversal(root);

        System.out.println();

        preOrderTraversalRecursion(root);
    }
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
        }
    }
}

