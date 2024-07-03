package BinaryTree;

import java.util.Stack;

public class BInOrderTraversal {
    static void inOrderTraversal(Node root){
        Stack<Node> stack = new Stack<>();
        while (true){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            if(stack.isEmpty())
                break;
            root = stack.pop();
            System.out.print(root.data + " ");
            root = root.right;
        }
    }
    static void inOrderTraversalRecursion(Node root){
        if(root != null){
            inOrderTraversalRecursion(root.left);
            System.out.print(root.data + " ");
            inOrderTraversalRecursion(root.right);
        }
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

        inOrderTraversal(root);

        System.out.println();

        inOrderTraversalRecursion(root);
    }
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
        }
    }
}
