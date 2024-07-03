package BinaryTree;

import java.util.HashSet;

public class DPostOrderTraversalWithoutStack {
    static void postOrderTraversal(Node root){
        HashSet<Node> visited = new HashSet<>();
        Node tmp = root;
        while(tmp != null && !visited.contains(tmp)) {
            if (tmp.left != null && !visited.contains(tmp.left))
                tmp = tmp.left;
            else if (tmp.right != null && !visited.contains(tmp.right))
                tmp = tmp.right;
            else{
                System.out.print(tmp.data + " ");
                visited.add(tmp);
                tmp = root;
            }
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

    }
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
        }
    }
}
