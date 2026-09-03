class Solution {
    TreeNode prev = null;
    TreeNode head = null;
    public TreeNode increasingBST(TreeNode root) {
        if(root == null) return null;

        increasingBST(root.left);

        if(head == null) head = root;
        if(prev != null) prev.right = root;

        root.left = null;
        prev = root;
        increasingBST(root.right);

        return head;
    }
}