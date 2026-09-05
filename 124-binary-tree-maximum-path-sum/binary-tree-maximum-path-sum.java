class Solution {
    static int maxSum;
    public int helper(TreeNode root){
        if(root == null) return 0;

        int l = helper(root.left);
        int r = helper(root.right);

        int case1 = l + r + root.val;
        int case2 = Math.max(l, r) + root.val;
        int case3 = root.val;

        maxSum = Math.max(Math.max(maxSum, case1), Math.max(case2, case3));

        return Math.max(case2, case3);
    }
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        
        helper(root);

        return maxSum;
    }
}