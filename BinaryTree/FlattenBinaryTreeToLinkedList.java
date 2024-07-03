package BinaryTree;

import java.util.Stack;

/*
Convert binary tree to linked list like below(add each node to right of parent node using preorder traversal)
                1                              1
              /   \                             \
             2     5            ===>             2
            / \     \                             \
           3   4     6                             3
                                                    \
                                                     4
                                                      \
                                                       5
                                                        \
                                                         6
 */
public class FlattenBinaryTreeToLinkedList {
    public static void flatten(Node root) {
        if(root == null)
            return;
        Stack<Node> stack = new Stack<>();
        while(true){
            if(root.right != null)
                stack.push(root.right);
            if(root.left == null){
                if(stack.isEmpty())
                    break;
                root.right = stack.pop();
            }
            else{
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
    static void flatten1(Node root){
        Node curr = root;
        while (curr != null) {
            if (curr.left != null) {
                Node runner = curr.left;
                while (runner.right != null) runner = runner.right;
                runner.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
    static void printPreOrder(Node root){
        if(root == null)
            return;

        System.out.print(root.data+ " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
    public static void main(String [] args) {
        Node root;
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);

        flatten(root);
        printPreOrder(root);
        System.out.println();

        Node root1;
        root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(5);
        root1.left.left = new Node(3);
        root1.left.right = new Node(4);
        root1.right.right = new Node(6);
        flatten1(root1);
        printPreOrder(root1);
    }
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
        }
    }
}
