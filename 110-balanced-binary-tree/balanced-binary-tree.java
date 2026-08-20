class Solution {
    static boolean flag;
    public int level(TreeNode root){
        if(root == null) return 0;
        int leftLevel = level(root.left);
        int rightLevel = level(root.right);

        if(Math.abs(leftLevel - rightLevel) > 1) flag = false;

        return 1 + Math.max(leftLevel, rightLevel);
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        flag = true; 
        level(root);

        return flag;
    }
}