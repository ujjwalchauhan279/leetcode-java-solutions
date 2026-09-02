class Solution {
    static int i;
    public void inorder(TreeNode root, ArrayList<Integer> arr){
        if(root == null) return;

        inorder(root.right, arr);
        arr.add(root.val);
        inorder(root.left, arr);
    }
    public void modify(TreeNode root, ArrayList<Integer> arr){
        if(root == null) return;

        modify(root.right, arr);
        root.val = arr.get(i++);
        modify(root.left, arr);
    }
    public TreeNode convertBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();

        inorder(root, arr);

        for(int j=1; j<arr.size(); j++){
            int sum = arr.get(j) + arr.get(j-1);
            arr.set(j, sum);
        }

        i=0;
        modify(root, arr);

        return root;
    }
}