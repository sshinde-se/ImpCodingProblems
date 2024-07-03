package BinaryTree;

import java.util.HashMap;

public class PConstructBinaryTreeFromPreOrderInOrder {
    static HashMap<Integer, Integer> mp = new HashMap<>();
    static int index;

    static Node buildTreeWrap(int []in, int []post, int len){
        for(int i=0; i<len; i++){
            mp.put(in[i], i);
        }
        index = len - 1;
        return buildTree(in, post, 0, len - 1);
    }
    static Node buildTree(int []in, int []post, int start, int end){
        if(start > end)
            return null;
        int curr = post[index];
        Node tNode = new Node(curr);
        index--;
        if(start == end)
            return tNode;
        int inIndex = mp.get(curr);
        tNode.right = buildTree(in, post, inIndex + 1, end);
        tNode.left = buildTree(in, post, start, inIndex - 1);
        return tNode;
    }

    public static void main(String[] args)
    {
        int[] in = { 4, 8, 2, 5, 1, 6, 3, 7 };
        int[] post = { 8, 4, 5, 2, 6, 7, 3, 1 };
        int n = in.length;
        Node root = buildTreeWrap(in, post, n);
        System.out.print(
                "Preorder of the constructed tree : \n");
        printPreOrder(root);
    }
    static void printPreOrder(Node root){
        if(root == null)
            return;

        System.out.print(root.data+ " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
        }
    }
}
