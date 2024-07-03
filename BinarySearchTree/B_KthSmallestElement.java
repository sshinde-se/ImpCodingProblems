package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class B_KthSmallestElement {
    static int kthSmallestElement(Node root, int k){
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list.get(k-1);
    }
    static void inOrder(Node root, List<Integer> l){
        if(root==null)
            return;
        inOrder(root.left, l);
        l.add(root.data);
        inOrder(root.right, l);
    }

    static int K;
    static int kthSmallestElement1(Node root, int k){
        K = k;
        return inOrder(root);
    }
    static Integer inOrder(Node root){
        if(root==null)
            return null;
        Integer left = inOrder(root.left);
        if(left == null){
            if(--K == 0)
                return root.data;
            return inOrder(root.right);
        }
        return left;
    }

    static int kthSmallestElementUsingStack(Node root, int k){
        Stack<Node> stack = new Stack<>();
        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(--k == 0)
                return root.data;
            root = root.right;
        }
        return -1;
    }
    public static void main(String [] args) {
        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(4);
        root.left.right = new Node(2);

        System.out.println(kthSmallestElement(root, 1));
        System.out.println(kthSmallestElement1(root, 1));
        System.out.println(kthSmallestElementUsingStack(root, 1));
    }
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
        }
    }
}
