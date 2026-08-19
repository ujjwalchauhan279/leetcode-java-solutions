class Solution {
    public void helper(TreeNode root, List<Integer> list, int level){
        if(root == null) return;

        if(level >= list.size()) list.add(root.val);
        else list.set(level, root.val);

        helper(root.left, list, level+1);
        helper(root.right, list, level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        helper(root, list, 0);

        return list;
    }
}