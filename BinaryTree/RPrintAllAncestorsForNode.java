package BinaryTree;

public class RPrintAllAncestorsForNode {
    static boolean printAllAncestor(Node root, Node node){
        if(root == null)
            return false;
        if(root.left == node || root.right == node ||
                printAllAncestor(root.left, node) || printAllAncestor(root.right, node))
        {
            System.out.print(root.data + " ");
            return true;
        }
        return false;
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

        boolean data = printAllAncestor(root, root.right.right);
        System.out.println(data);

    }
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
        }
    }
}
