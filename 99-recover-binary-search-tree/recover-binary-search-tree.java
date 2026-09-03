class Solution {
    static int i;
    public void inorder(TreeNode root, ArrayList<Integer> arr){
        if(root == null) return;

        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
    }
    public void modify(TreeNode root, ArrayList<Integer> arr){
        if(root == null) return;

        modify(root.left, arr);
        if(root.val != arr.get(i)) root.val = arr.get(i);
        i++;
        modify(root.right, arr);
    }
    public void recoverTree(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();

        inorder(root, arr);
        Collections.sort(arr);

        i = 0;
        modify(root, arr);
    }
}