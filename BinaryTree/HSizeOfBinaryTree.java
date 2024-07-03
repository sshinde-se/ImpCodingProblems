package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class HSizeOfBinaryTree {
    static int sizeOfBinaryTreeUsingRecursion(Node root){
        if(root == null)
            return 0;
        return sizeOfBinaryTreeUsingRecursion(root.left) + 1 + sizeOfBinaryTreeUsingRecursion(root.right);
    }
    static int sizeOfBinaryTreeUsingQueue(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int cnt=0;
        while (!queue.isEmpty()){
            Node tmp = queue.poll();
            cnt++;
            if(tmp.left != null)
                queue.add(tmp.left);
            if(tmp.right != null)
                queue.add(tmp.right);
        }
        return cnt;
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

        System.out.println(sizeOfBinaryTreeUsingRecursion(root));
        System.out.println(sizeOfBinaryTreeUsingQueue(root));

    }
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
        }
    }
}
