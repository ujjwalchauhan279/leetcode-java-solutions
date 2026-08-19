class Solution {
    public void helper(TreeNode root, int arr[], int level){
        if(root == null) return;

        arr[level] = root.val;

        helper(root.left, arr, level+1);
        helper(root.right, arr, level+1);
    }
    
    public int levels(TreeNode root){
        if(root == null) return 0;

        return 1 + Math.max(levels(root.left), levels(root.right));
    }
    public List<Integer> rightSideView(TreeNode root) {
        int l = levels(root);

        List<Integer> list = new ArrayList<>();
        int arr[] = new int[l];

        helper(root, arr, 0);

        for(int ele: arr) list.add(ele);

        return list;
    }
}