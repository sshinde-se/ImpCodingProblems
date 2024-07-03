package BinaryTree;

/*
The minimum depth is the number of nodes along the shortest path from the root
node down to the nearest leaf node.


            3
           / \
          9   20
             /  \
            15   7
Note: A leaf is a node with no children.
 */
public class Z2MinDepthOfBinaryTree {
    public static void main(String [] args) {
        Node root;
        root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        System.out.println(minDepth(root));
        System.out.println();

        Node root1;
        root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(2);
        root1.left.left = new Node(3);
        root1.left.right = new Node(3);
        root1.left.left.left = new Node(4);
        root1.left.left.right = new Node(4);
        System.out.println(minDepth(root1));
    }

    private static int minDepth(Node root) {
        if(root == null)
            return 0;
        else if(root.left == null && root.right == null)
            return 1;
        else if (root.left == null)
            return minDepth(root.right) + 1;
        else if(root.right == null)
            return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) +1;
    }

    static class Node{
        int data;
        Node left, right, next;
        public Node(int data){
            this.data = data;
        }
    }
}
