class Solution {
    public TreeNode helper(int preorder[], int inorder[], int prelow, int prehigh, int inlow, int inhigh){
        if(prelow > prehigh) return null;
        int val = preorder[prelow];
        TreeNode root = new TreeNode(val);

        int r = -1;
        for(int i=inlow; i<=inhigh; i++){
            if(inorder[i] == val){
                r = i;
                break;
            }
        }
        int x = r - inlow;
        
        root.left = helper(preorder, inorder, prelow+1, prelow+x, inlow, r-1);
        root.right = helper(preorder, inorder, prelow+(x+1), prehigh, r+1, inhigh);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return helper(preorder, inorder, 0, n-1, 0, n-1);
    }
}