package BinaryTree;

import java.util.Stack;

/*
Check whether it is a mirror of itself (i.e., symmetric around its center) using isSymmetric
                 1
              /     \
             2       2
            / \     / \
           3   4   4   3

Check if two trees are mirror to each other using checkMirror
                1                     1
              /   \                 /   \
             2     3               3     2
            / \                         /  \
           4   5                       5    4
 */
public class NIsMirrorTreeOrSymmetricTree {
    static boolean isSymmetric(TreeNode root){
        return checkMirror(root.left, root.right);
    }
    static boolean checkMirror(TreeNode p, TreeNode q){
        if(p == null && q == null)
            return true;
        if(p == null || q == null)
            return false;
        if(p.val != q.val)
            return false;
        return checkMirror(p.left, q.right) && checkMirror(p.right, q.left);
    }
    static boolean isMirrorIterative(TreeNode p, TreeNode q){
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(p);
        s2.push(q);
        while(!s1.isEmpty() && !s2.isEmpty()){
            TreeNode c1 = s1.pop();
            TreeNode c2 = s2.pop();

            if(c1.val != c2.val)
                return false;

            if(c1.left != null && c2.right != null) {
                s1.push(c1.left);
                s2.push(c2.right);
            }
            else if(c1.left != null || c2.right != null)
                return false;

            if(c1.right != null && c2.left != null){
                s1.push(c1.right);
                s2.push(c2.left);
            }
            else if (c1.right != null || c2.left != null)
                return false;
        }
        if(!s1.isEmpty() || !s2.isEmpty())
            return false;
        return true;
    }
    public static void main(String [] args){
        TreeNode root =new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println("Single tree recursion mirror check: " + isSymmetric(root));
        System.out.println("Single tree Iterative mirror check: " + isMirrorIterative(root.left, root.right));

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        p.left.left = new TreeNode(4);
        p.left.right = new TreeNode(5);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(3);
        q.right = new TreeNode(2);
        q.right.left = new TreeNode(5);
        q.right.right = new TreeNode(4);

        System.out.println("Recursion two trees: " + checkMirror(p, q));
        System.out.println("Iterative with two trees: " + isMirrorIterative(p, q));
    }
    static class TreeNode{
        int val;
        TreeNode left, right;
        public TreeNode(int val){
            this.val = val;
        }
    }
}
