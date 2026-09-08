class Solution {
    public void inorder(TreeNode root, ArrayList<Integer> arr){
        if(root == null) return;

        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
    }
    public TreeNode BST(ArrayList<Integer> arr, int low, int high){
        if(high < low) return null;

        int mid = low + (high - low)/2;
        TreeNode root = new TreeNode(arr.get(mid));

        root.left = BST(arr, low, mid-1);
        root.right = BST(arr, mid+1, high);

        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();

        inorder(root, arr);

        int n = arr.size();

        return BST(arr, 0, n-1);
    }
}