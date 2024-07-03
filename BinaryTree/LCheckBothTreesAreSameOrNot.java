package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LCheckBothTreesAreSameOrNot {
    public static boolean isSameTree(Node p, Node q) {
        if(p == null && q == null)
            return true;
        if(p == null || q == null)
            return false;
        return (p.data == q.data && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
    static boolean isSameTreeUsingQueue(Node p, Node q){
        if(p == null && q == null)
            return true;
        if(p == null || q == null)
            return false;
        Queue<Node> queue = new LinkedList<>();
        queue.add(p);
        Queue<Node> queue1 = new LinkedList<>();
        queue1.add(q);
        while (!queue.isEmpty() && !queue1.isEmpty()){
            Node tmp = queue.poll();
            Node tmp1 = queue1.poll();
            if(tmp.data != tmp1.data)
                return false;
            if((tmp.left != null && tmp1.left == null)||(tmp.left == null && tmp1.left != null))
                return false;
            if((tmp.right != null && tmp1.right == null)||(tmp.right == null && tmp1.right != null))
                return false;

            if(tmp.left!=null && tmp1.left!= null){
                queue.add(tmp.left);
                queue1.add(tmp1.left);
            }
            if(tmp.right!=null && tmp1.right != null) {
                queue.add(tmp.right);
                queue1.add(tmp1.right);
            }
        }
        return true;
    }
    static boolean isSameTreeUsing3Traversal(Node p, Node q){
        ArrayList<Integer> res1 = new ArrayList<Integer>();
        ArrayList<Integer> res2 = new ArrayList<Integer>();

        preOrder(p ,res1);
        preOrder(q, res2);
        if(!res1.equals(res2))
            return false;
        res1.clear();
        res2.clear();

        inOrder(p ,res1);
        inOrder(q, res2);
        if(!res1.equals(res2))
            return false;
        res1.clear();
        res2.clear();

        postOrder(p ,res1);
        postOrder(q, res2);
        if(!res1.equals(res2))
            return false;

        return true;
    }
    static void preOrder(Node root, ArrayList<Integer> sol){
        if(root == null)
            return;
        sol.add(root.data);
        preOrder(root.left, sol);
        preOrder(root.right, sol);
    }
    static void inOrder(Node root, ArrayList<Integer> sol){
        if(root == null)
            return;
        inOrder(root.left, sol);
        sol.add(root.data);
        inOrder(root.right, sol);
    }
    static void postOrder(Node root, ArrayList<Integer> sol){
        if(root == null)
            return;
        postOrder(root.left, sol);
        postOrder(root.right, sol);
        sol.add(root.data);
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

        Node root1;
        root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        System.out.println(isSameTree(root, root1));

        Node p = new Node(1);
        p.left = new Node(2);
        p.right = new Node(3);

        Node q = new Node(1);
        q.left = new Node(2);
        q.right = new Node(3);
        System.out.println(isSameTreeUsingQueue(p, q));

        Node p1 = new Node(1);
        p1.left = new Node(2);

        Node q1 = new Node(1);
        q1.right = new Node(2);
        System.out.println(isSameTreeUsing3Traversal(p1, q1));

    }
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
        }
    }
}
