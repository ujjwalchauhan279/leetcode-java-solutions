class Solution {
    public void path(TreeNode root, List<String> list, String s){
        if(root == null) return;

        if(!s.isEmpty()) s += "->";
        s += root.val;

        if(root.left == null && root.right == null){
            list.add(s);
        }

        path(root.left, list, s);
        path(root.right, list, s);

    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();

        path(root, list, "");

        return list;
    }
}