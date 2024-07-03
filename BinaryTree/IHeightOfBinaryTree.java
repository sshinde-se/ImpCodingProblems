package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class IHeightOfBinaryTree {
    static int heightOfBinaryTreeUsingRecursion(Node root){
        int leftH, rightH;
        if(root == null)
            return 0;
        else {
            leftH = heightOfBinaryTreeUsingRecursion(root.left);
            rightH = heightOfBinaryTreeUsingRecursion(root.right);

            if (leftH > rightH)
                return leftH + 1;
            else
                return rightH + 1;
        }
    }
    static int heightOfBinaryTreeUsingQueue(Node root){
        Queue<Node> queue = new LinkedList<>();
        int h = 0;
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()){
            root = queue.poll();
            if(root == null){
                if(!queue.isEmpty())
                    queue.add(null);
                h++;
            }
            else{
                if(root.left != null)
                    queue.add(root.left);
                if(root.right != null)
                    queue.add(root.right);
            }
        }
        return h;
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

        System.out.println(heightOfBinaryTreeUsingRecursion(root));
        System.out.println(heightOfBinaryTreeUsingQueue(root));

    }
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
        }
    }
}
