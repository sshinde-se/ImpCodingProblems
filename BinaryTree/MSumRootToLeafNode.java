package BinaryTree;

import java.util.Stack;

/*

                4
               / \
              9   0
             / \
            5   1
    The root-to-leaf path 4->9->5 represents the number 495.
    The root-to-leaf path 4->9->1 represents the number 491.
    The root-to-leaf path 4->0 represents the number 40.
    Therefore, sum = 495 + 491 + 40 = 1026
 */
public class MSumRootToLeafNode {
    private static int sumNumbers(Node root) {
        Stack<Node> stack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        int res=0, sum =0;
        stack.add(root);
        sumStack.add(root.data);
        while (!stack.isEmpty() && !sumStack.isEmpty()){
            Node tmp = stack.pop();
            sum = sumStack.pop();

            if(tmp.left == null && tmp.right == null){
                res = res + sum;
            }
            if(tmp.left != null){
                stack.push(tmp.left);
                sumStack.push(sum*10 + tmp.left.data);
            }
            if(tmp.right != null){
                stack.push(tmp.right);
                sumStack.push(sum*10 + tmp.right.data);
            }
        }
        return res;
    }
    static int result = 0;
    private static int sumNumbersUsingRecursion(Node root) {
        sum(root, 0);
        return result;
    }
    public static void sum(Node root, int num){
        if(root == null)
            return;
        int sum = root.data + 10* num;
        if(root.left == null && root.right == null)
            result += sum;
        sum(root.left, sum);
        sum(root.right, sum);
    }
    public static void main(String [] args) {
        Node root;
        root = new Node(4);
        root.left = new Node(9);
        root.right = new Node(0);
        root.left.left = new Node(5);
        root.left.right = new Node(1);

        System.out.println(sumNumbers(root));
        System.out.println();
        System.out.println(sumNumbersUsingRecursion(root));
    }
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
        }
    }
}
