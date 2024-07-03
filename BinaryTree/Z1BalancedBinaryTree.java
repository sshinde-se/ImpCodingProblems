package BinaryTree;

/*
Given a binary tree, determine if it is height-balanced
A height-balanced binary tree is a binary tree in which the depth of the two subtrees of
every node never differs by more than one.

            true                            false
            3                                  1
           / \                                / \
          9   20                             2   2
             /  \                           / \
            15   7                         3   3
                                          / \
                                         4   4
 */

public class Z1BalancedBinaryTree {
    private static boolean balancedBinaryTree(Node root) {
        if(root == null)
            return false;
        if(height(root) == -1)
            return false;
        return true;
    }
    private static int height(Node root) {
        if(root == null)
            return 0;
        int lh = height(root.left);
        int rh = height(root.right);

        if(lh == -1 || rh == -1)
            return -1;
        if(Math.abs(lh-rh) > 1)
            return -1;
        return Math.max(lh, rh) + 1;
    }
    public static void main(String [] args) {
        Node root;
        root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        System.out.println(balancedBinaryTree(root));
        System.out.println();

        Node root1;
        root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(2);
        root1.left.left = new Node(3);
        root1.left.right = new Node(3);
        root1.left.left.left = new Node(4);
        root1.left.left.right = new Node(4);
        System.out.println(balancedBinaryTree(root1));
    }
    static class Node{
        int data;
        Node left, right, next;
        public Node(int data){
            this.data = data;
        }
    }
}
