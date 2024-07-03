package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class GFindMaxElementUsingLevelOrderTraversal {
    static int maxElementUsingLevelOrderTraversal(Node root){
        Queue<Node> queue = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        queue.add(root);
        while (!queue.isEmpty()){
            Node tmp = queue.poll();
            if(tmp.data > max){
                max = tmp.data;
            }
            if(tmp.left != null)
                queue.add(tmp.left);
            if(tmp.right != null)
                queue.add(tmp.right);
        }
        return max;
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

        System.out.println(maxElementUsingLevelOrderTraversal(root));

    }
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
        }
    }
}
