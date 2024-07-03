package BinaryTree;

import java.util.Stack;

public class CPostOrderTraversalUsingTwoStacks {
    static void postOrderTraversal(Node root){
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()){
            Node tmp = s1.pop();
            s2.push(tmp);

            if(tmp.left != null)
                s1.push(tmp.left);
            if(tmp.right != null)
                s1.push(tmp.right);
        }
        while (!s2.isEmpty()){
            Node tmp = s2.pop();
            System.out.print(tmp.data + " ");
        }
    }
    static void postOrderTraversalRecursion(Node root){
        if(root != null){
            postOrderTraversalRecursion(root.left);
            postOrderTraversalRecursion(root.right);
            System.out.print(root.data + " ");
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

        postOrderTraversal(root);

        System.out.println();

        postOrderTraversalRecursion(root);
    }
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
        }
    }
}
