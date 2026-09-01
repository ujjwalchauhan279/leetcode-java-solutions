class Solution {
    static int i;
    static int ans;
    public void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
        i--;
        if(i == 0) ans = root.val;
        inorder(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        i = k;

        inorder(root);

        return ans;
    }
}