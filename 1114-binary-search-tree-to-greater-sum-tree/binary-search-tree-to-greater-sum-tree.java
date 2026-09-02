class Solution {
    static int i;
    static ArrayList<Integer> arr;
    public void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.right);
        arr.add(root.val);
        inorder(root.left);
    }
    public void modify(TreeNode root){
        if(root == null) return;

        modify(root.right);
        root.val = arr.get(i++);
        modify(root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
        arr = new ArrayList<>();

        inorder(root);

        for(int j=1; j<arr.size(); j++){
            int sum = arr.get(j) + arr.get(j-1);
            arr.set(j, sum);
        }

        i = 0;
        modify(root);

        return root;
    }
}