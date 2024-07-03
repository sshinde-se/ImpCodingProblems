package BinaryTree;

import java.util.*;

public class ZPopulatingNextPointForEachNode {
    public static Node connect(Node root) {
        if(root == null)
            return null;
        Node tmp;
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        que.add(null);
        //root.next = null;
        while(!que.isEmpty()){
            tmp = que.poll();
            if(tmp == null){
                if(!que.isEmpty())
                    que.add(null);
                while(que.peek() != null){
                    tmp = que.poll();
                    if (tmp.left != null)
                        que.add(tmp.left);
                    if (tmp.right != null)
                        que.add(tmp.right);
                    tmp.next = que.peek();
                }
            }
            else {
                if (tmp.left != null)
                    que.add(tmp.left);
                if (tmp.right != null)
                    que.add(tmp.right);
            }
        }
        return root;
    }
    static void printNextNodes(Node root){
        if(root == null)
            return;
        if(root.next != null){
            System.out.print(root.data+ ":"+root.next.data+" ");
        }
        printNextNodes(root.left);
        printNextNodes(root.right);
    }
    public static Node connectUsingDFS(Node root) {
        Map<Integer, List<Node>> map = new HashMap<>();
        goDFS(root, 0, map);
        for (List<Node> list : map.values())
            for (int i = 1; i < list.size(); i++)
                list.get(i - 1).next = list.get(i);
        return root;
    }

    private static void goDFS(Node node, int lvl, Map<Integer, List<Node>> map) {
        if (node == null) return;

        List<Node> list = map.computeIfAbsent(lvl, ArrayList::new);
        list.add(node);
        lvl++;
        goDFS(node.left, lvl, map);
        goDFS(node.right, lvl, map);
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

        Node node = connect(root);
        printNextNodes(node);

        System.out.println();
        Node root1;
        root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);
        Node node1 = connectUsingDFS(root1);
        printNextNodes(node1);
    }
    static class Node{
        int data;
        Node left, right, next;
        public Node(int data){
            this.data = data;
        }
    }
}
