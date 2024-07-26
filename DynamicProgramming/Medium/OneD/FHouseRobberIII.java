package DynamicProgramming.Medium.OneD;

import java.util.HashMap;

/*
Besides the root, each house has one and only one parent house. After a tour,
the smart thief realized that all houses in this place form a binary tree. It will automatically
contact the police if two directly-linked houses were broken into on the same night.

Given the root of the binary tree, return the maximum amount of money the thief can rob without
alerting the police.
            3
           / \
          20  5
         /     \
        100     1

        Here if we take 3 + 100 +1=104
        if we not take root i.e 3 then take max from root.left so here max is 100 and max from root.right is 5.
        100 + 5 =105

 */
public class FHouseRobberIII {
    public static void main(String[] args){
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(20);
        node.right = new TreeNode(5);
        node.left.left = new TreeNode(100);
        node.right.right = new TreeNode(1);

        System.out.println("Max amount to be robbed: "+ robUsingDFS(node));
        System.out.println("Max amount to be robbed using HashMap: "+ robUsingHashMap(node));
    }

    private static int robUsingHashMap(TreeNode root) {
        return rob(root,0, 0, new HashMap<>());
    }
    private static int rob(TreeNode root,int left, int right, HashMap<TreeNode,Integer> hmap){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.val;

        if(hmap.containsKey(root))
            return hmap.get(root);

        if(root.left!=null)
            left = rob(root.left.left,0,0,hmap) + rob(root.left.right,0,0,hmap);
        if(root.right!=null)
            right = rob(root.right.left,0,0,hmap) + rob(root.right.right,0,0,hmap);

        int sum = left + right + root.val;
        int res = Math.max(sum, rob(root.left,0,0,hmap) + rob(root.right,0,0,hmap));
        hmap.put(root, res);
        return res;
    }
    private static int robUsingDFS(TreeNode root) {
        int[] ans = DFS(root);
        return Math.max(ans[0], ans[1]);
    }
    private static int[] DFS(TreeNode root){
        if(root == null)
            return new int[]{0,0};

        int[] leftPair = DFS(root.left);
        int[] rightPair = DFS(root.right);

        //its like pick, non pick in dp for pick i.e withRoot we will get child element without that root
        int withRoot = root.val + leftPair[1] + rightPair[1];
        int withoutRoot = Math.max(leftPair[0], leftPair[1]) + Math.max(rightPair[0], rightPair[1]);

        return new int[]{withRoot, withoutRoot};
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
}
