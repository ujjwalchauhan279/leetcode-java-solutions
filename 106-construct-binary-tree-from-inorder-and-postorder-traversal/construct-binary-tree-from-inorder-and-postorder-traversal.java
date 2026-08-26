class Solution {
    public TreeNode helper(int[] inorder, int[] postorder, int postlow, int posthigh, int inlow, int inhigh){
        if(inlow > inhigh) return null;
        int val = postorder[posthigh];
        TreeNode root = new TreeNode(val);

        int r = -1;
        for(int i=inlow; i<=inhigh; i++){
            if(inorder[i] == val){
                r = i;
                break;
            }
        }

        int x = r - inlow;

        root.left = helper(inorder, postorder, postlow, postlow+x-1, inlow, r-1);
        root.right = helper(inorder, postorder, postlow + x, posthigh-1, r+1, inhigh);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return helper(inorder, postorder, 0, n-1, 0, n-1);
    }
}