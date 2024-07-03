package BinaryTree;

import java.util.AbstractMap.SimpleEntry;
import java.util.Stack;

/*

                -10
               /   \
              9     20
                   /  \
                  15   7
The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42
 */
public class VMaxPathSum {
    static int res = Integer.MIN_VALUE;
    static int findMaxSum(Node root){
        if(root == null)
            return 0;
        int l = Math.max(0, findMaxSum(root.left));
        int r = Math.max(0, findMaxSum(root.right));

        int max = Math.max(Math.max(l,r) + root.data, root.data);
        int maxTop = Math.max(max, root.data + l + r);

        res = Math.max(res, maxTop);

        return max;
    }
    public static int maxPathSum(Node root) {
        res = Integer.MIN_VALUE;
        findMaxSum(root);
        return res;
    }

    public static int maxPathSumUsingStack(Node root) {
        if(root == null)
            return 0;
        Stack<SimpleEntry<Node, Integer>> stack = new Stack<>();
        int maxSum = Integer.MIN_VALUE;
        stack.push(new SimpleEntry<>(root, 0));
        while(!stack.isEmpty()){
            SimpleEntry<Node, Integer> pair = stack.pop();
            Node tmp = pair.getKey();
            int state = pair.getValue();
            if(tmp == null)
                continue;
            if(state == 0){
                stack.push(new SimpleEntry<>(tmp, 1));
                stack.push(new SimpleEntry<>(tmp.left, 0));
            }
            else if(state == 1){
                stack.push(new SimpleEntry<>(tmp, 2));
                stack.push(new SimpleEntry<>(tmp.right, 0));
            }
            else{
                int leftSum = tmp.left!=null ? tmp.left.data : 0;
                int rightSum = tmp.right!=null ? tmp.right.data : 0;
                maxSum = Math.max(maxSum, tmp.data + Math.max(0, leftSum) + Math.max(0,rightSum));
                int childSum = Math.max(leftSum, rightSum);
                tmp.data += Math.max(0, childSum);
            }
        }
        return maxSum;
    }
    public static void main(String [] args) {
        Node root;
        root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        res = maxPathSum(root);
        System.out.println(res);
        System.out.println();
        int res1= maxPathSumUsingStack(root);
        System.out.println(res1);
    }
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
        }
    }
    
}
