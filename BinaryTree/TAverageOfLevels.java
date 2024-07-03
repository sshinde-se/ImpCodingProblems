package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TAverageOfLevels {
    private static List<Double> averageOfLevels(Node root) {
        List<Double> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            double n = queue.size();
            long sum=0;
            for(int i=0;i<n;i++){
                Node tmp = queue.poll();
                sum += tmp.data;
                if(tmp.left!=null)
                    queue.add(tmp.left);
                if(tmp.right!=null)
                    queue.add(tmp.right);
            }
            list.add(sum/n);
        }
        return list;
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


        System.out.println();
        List<Double> list = averageOfLevels(root);
        for(double a: list){
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
