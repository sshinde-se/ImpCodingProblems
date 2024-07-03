package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

//Leave nodes are nodes which both left and right children are null
public class JNumberOfLeavesInBinaryTree {
    static int numberOfLeaves(Node root){
        Queue<Node> queue = new LinkedList<>();
        int count=0;
        queue.add(root);
        while (!queue.isEmpty()){
            Node tmp = queue.poll();
            if(tmp.left == null && tmp.right == null)
                count++;
            else{
                if(tmp.left != null)
                    queue.add(tmp.left);
                if(tmp.right != null)
                    queue.add(tmp.right);
            }
        }
        return count;
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

        System.out.println(numberOfLeaves(root));

    }
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
        }
    }
}
