class Solution {
    public TreeNode helper(int nums[], int low, int high){
        if(high < low) return null;

        int mid = low + (high - low)/2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = helper(nums, low, mid-1);
        node.right = helper(nums, mid+1, high);

        return node;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return helper(nums, 0, n-1);
    }
}