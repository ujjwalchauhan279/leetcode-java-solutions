class Solution {
    static int i;
    static int sum;
    public void inorder(TreeNode root, ArrayList<Integer> arr){
        if(root == null) return;

        inorder(root.right, arr);
        arr.add(root.val);
        inorder(root.left, arr);
    }
    public void modify(TreeNode root, ArrayList<Integer> arr){
        if(root == null) return;

        modify(root.right, arr);
        sum += arr.get(i++);
        root.val = sum;
        modify(root.left, arr);
    }
    public TreeNode convertBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();

        inorder(root, arr);

        sum = 0;

        i=0;
        modify(root, arr);

        return root;
    }
}