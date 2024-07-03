package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class YRightViewOfBinaryTree {
    static int maxLevel = 0;
    static List<Integer> rightViewOfTree(Node root){
        List<Integer> list = new ArrayList<>();
        rightView(root, 1, list);
        return list;
    }
    static void rightView(Node root, int level, List<Integer> list){
        if(root == null)
            return;
        if(maxLevel < level){
            list.add(root.data);
            maxLevel = level;
        }
        rightView(root.right, level+1, list);
        rightView(root.left, level+1, list);
    }
    static List<Integer> rightViewOfTreeUsingQueue(Node root){
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            for(int i=0; i<n; i++){
                Node tmp = queue.poll();
                if(tmp !=null) {
                    if (i == n - 1)
                        list.add(tmp.data);
                    if (tmp.left != null)
                        queue.add(tmp.left);
                    if (tmp.right != null)
                        queue.add(tmp.right);
                }
            }
        }
        return list;
    }
    static List<Integer> leftViewOfTree(Node root){
        maxLevel = 0;
        List<Integer> list = new ArrayList<>();
        leftView(root, 1, list);
        return list;
    }
    static void leftView(Node root, int level, List<Integer> list){
        if(root == null)
            return;
        if(maxLevel < level){
            list.add(root.data);
            maxLevel = level;
        }
        leftView(root.left, level+1, list);
        leftView(root.right, level+1, list);
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

        List<Integer> list = rightViewOfTree(root);
        for(int a: list){
            System.out.print(a + " ");
        }
        System.out.println();
        List<Integer> list1 = leftViewOfTree(root);
        for(int a: list1){
            System.out.print(a + " ");
        }
        System.out.println();
        List<Integer> list2 = rightViewOfTreeUsingQueue(root);
        for(int a: list2){
            System.out.print(a + " ");
        }
    }
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
        }
    }
}
