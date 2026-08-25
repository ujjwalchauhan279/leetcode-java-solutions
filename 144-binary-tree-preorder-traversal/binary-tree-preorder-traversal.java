
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if(root == null) return list;
        st.push(root);

        while(st.size() != 0){
            TreeNode pop = st.pop();
            list.add(pop.val);

            if(pop.right != null) st.push(pop.right);
            if(pop.left != null) st.push(pop.left);
        }

        return list;
    }
}