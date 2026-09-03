class Solution {
    public TreeNode helper(int preorder[], int low, int high){
        if(low > high) return null;

        TreeNode root = new TreeNode(preorder[low]);

        int i = low+1; 
        while(i <= high && preorder[low] >= preorder[i]){
            i++;
        }

        root.left = helper(preorder, low+1, i-1);
        root.right = helper(preorder, i, high);

        return root;

    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;

        return helper(preorder, 0, n-1);
    }
}