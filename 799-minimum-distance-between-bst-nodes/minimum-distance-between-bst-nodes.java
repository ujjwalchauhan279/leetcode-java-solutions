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
    TreeNode prev;
    static int min;
    public void helper(TreeNode root){
        if(root == null) return ;

        helper(root.left);
        if(prev != null){
            min = Math.min(min, Math.abs(prev.val - root.val));
        }
        prev = root;
        helper(root.right);
    }
    public int minDiffInBST(TreeNode root) {
        if(root == null) return 0;
        prev = null;

        min = Integer.MAX_VALUE;
        helper(root);

        return min;
    }
}