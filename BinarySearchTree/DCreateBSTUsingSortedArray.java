package BinarySearchTree;

/*
Given an integer array nums where the elements are sorted in ascending order,
convert it to a height-balanced binary search tree.

Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

            0               0
           / \             / \
         -3   9         -10   5
         /   /            \    \
       -10  5             -3    9
 */
public class DCreateBSTUsingSortedArray {
    public static void main(String [] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        Node root = createBST(nums, 0, nums.length-1);
        printNode(root);
    }

    private static Node createBST(int[] nums, int l, int r) {
        if(l>r)
            return null;
        int mid = l+(r-l)/2;
        Node root = new Node(nums[mid]);
        root.left = createBST(nums, l, mid-1);
        root.right = createBST(nums, mid+1, r);
        return root;
    }
    private static void printNode(Node root){
        if(root == null)
            return;
        printNode(root.left);
        System.out.println(root.data + " ");
        printNode(root.right);
    }
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
        }
    }
}
