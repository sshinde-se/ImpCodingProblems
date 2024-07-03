package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
/*
  Invert tree like below
              4                     4
           /    \                 /   \
          2      7               7     2
         / \    / \             / \   / \
        1   3  6   9           9   6 3   1
 */
public class XInvertTree {
    static Node invertTree(Node root){
        if(root == null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node tmp = queue.poll();
            invert(tmp);
            if(tmp.left != null)
                queue.add(tmp.left);
            if(tmp.right != null)
                queue.add(tmp.right);
        }
        return root;
    }
    static void invert(Node root){
        if(root == null)
            return;
        Node tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
    static Node invertTreeUsingRecursion(Node root){
        if(root == null)
            return null;
        Node tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invert(root.left);
        invert(root.right);
        return root;
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
        invertTree(root);

        Node root1;
        root1 = new Node(4);
        root1.left = new Node(2);
        root1.right = new Node(7);
        root1.left.left = new Node(1);
        root1.left.right = new Node(3);
        root1.right.left = new Node(6);
        root1.right.right = new Node(9);
        invertTreeUsingRecursion(root1);
    }
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
        }
    }
}
