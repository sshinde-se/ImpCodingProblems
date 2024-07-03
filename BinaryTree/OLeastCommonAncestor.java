package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class OLeastCommonAncestor {
    static Node leastCommonAncestor(Node root, Node p, Node q){
        if(root == null)
            return root;
        if(root == p || root == q)
            return root;
        Node left = leastCommonAncestor(root.left, p, q);
        Node right = leastCommonAncestor(root.right, p, q);
        if(left != null && right != null)
            return root;
        else return (left!= null? left : right);
    }

    //Using ArrayList
    /*
                        1
                       / \
                      2    3
                     / \  / \
                    4   5 6  7

    Path from root to 5 = { 1, 2, 5 }
    Path from root to 6 = { 1, 3, 6 }

    We start checking from 0 index. As both of the value matches( pathA[0] = pathB[0] ),
    we move to the next index.
    pathA[1] not equals to pathB[1], there’s a mismatch so we consider the previous value.
    Therefore the LCA of (5,6) = 1
     */
    static Node LCAUsingArrayList(Node root, Node p, Node q){
        List<Node> path1 = new ArrayList<>();
        List<Node> path2 = new ArrayList<>();
        if(!findPath(root, p, path1) || !findPath(root, q, path2))
            return null;
        int i;
        for(i=0; i< path1.size() && i< path2.size(); i++){
            if(!path1.get(i).equals(path2.get(i)))
                break;
        }
        return path1.get(i-1);
    }
    static boolean findPath(Node root, Node n, List<Node> path){
        if(root == null)
            return false;
        path.add(root);
        if(root == n || findPath(root.left, n, path) || findPath(root.right, n, path))
            return true;
        path.remove(path.size()-1);
        return false;
    }


    public static void main(String [] args) {
        Node root;
        root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right = new Node(8);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);

        int data = leastCommonAncestor(root, root.left.right.left, root.left.right.right).data;
        System.out.println(data);
        int data1 = LCAUsingArrayList(root, root.left.right.left, root.left.right.right).data;
        System.out.println(data1);

    }
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
        }
    }
}
