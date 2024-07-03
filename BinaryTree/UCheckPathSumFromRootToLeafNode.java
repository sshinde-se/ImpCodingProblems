package BinaryTree;

import java.util.Stack;

public class UCheckPathSumFromRootToLeafNode {
    private static boolean hasPathSumUsingRecursion(Node root, int sum) {
        if(root == null)
            return false;
        boolean ans = false;
        int subSum = sum - root.data;
        if(subSum == 0 && root.left == null && root.right == null)
            return true;
        if(root.left != null){
            ans = ans || hasPathSumUsingRecursion(root.left, subSum);
        }
        if(root.right != null){
            ans = ans || hasPathSumUsingRecursion(root.right, subSum);
        }
        return ans;
    }
    private static boolean hasPathSum(Node root, int targetSum){
        if(root == null)
            return false;
        Stack<Node> stack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        stack.add(root);
        sumStack.add(root.data);
        while (!stack.isEmpty() && !sumStack.isEmpty()){
            Node tmp = stack.pop();
            int sum = sumStack.pop();
            if(tmp.left == null && tmp.right == null && sum == targetSum)
                return true;
            if(tmp.left != null){
                stack.push(tmp.left);
                sumStack.push(sum + tmp.left.data);
            }
            if(tmp.right != null){
                stack.push(tmp.right);
                sumStack.push(sum + tmp.right.data);
            }
        }
        return false;
    }
    public static void main(String [] args) {
        Node root;
        root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);
        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.right.right.right = new Node(1);

        System.out.println(hasPathSumUsingRecursion(root, 22));
        System.out.println();
        System.out.println(hasPathSum(root, 22));
    }

    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
        }
    }
}
