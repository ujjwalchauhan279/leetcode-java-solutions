class Solution {
    static int sum;
    public TreeNode bstToGst(TreeNode root){
        sum=0;
        inorder(root);

        return root;
    }
    public void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.right);
        sum += root.val;
        root.val = sum;
        inorder(root.left);
    }
}