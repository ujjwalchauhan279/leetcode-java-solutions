class Solution {
    public void preOrder(TreeNode root, ArrayList<TreeNode> list){
        if(root == null) return;

        list.add(root);
        preOrder(root.left, list); 
        preOrder(root.right, list);
    }
    public void flatten(TreeNode root) {
        if(root == null) return;
        ArrayList<TreeNode> list = new ArrayList<>();

        preOrder(root, list);
        list.get(0).left = null;

        for(int i=1; i<list.size(); i++){
            list.get(i-1).right = list.get(i);
            list.get(i).left = null;
        }

        list.get(list.size()-1).right = null;

    }
}