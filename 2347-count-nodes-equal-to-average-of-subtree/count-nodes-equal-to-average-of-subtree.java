class Solution {
    static int ans;
    public int sum(TreeNode root){
        if(root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }
    public int size(TreeNode root){
        if(root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }
    public void helper(TreeNode root){
        if(root == null) return;
        int s = sum(root);
        int x = size(root);

        if(root.val == (s/x)) ans++;

        helper(root.left);
        helper(root.right);
    }
    public int averageOfSubtree(TreeNode root) {
        if(root == null) return 0;

        ans = 0;
        helper(root);

        return ans;
    }
}