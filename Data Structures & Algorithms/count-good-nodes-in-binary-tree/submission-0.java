/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        preOrder(root, -100);
        return res;
    }
    int res = 0;
    private void preOrder(TreeNode root, int maxValue) {
        if (root == null) return;
        if (root.val >= maxValue) res++;
        preOrder(root.left, Math.max(maxValue, root.val));
        preOrder(root.right, Math.max(maxValue, root.val));
    }
}
