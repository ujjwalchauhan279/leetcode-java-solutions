class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        boolean left = true;

        while(q.size() > 0){
            int size = q.size();
            List<Integer> innerList = new ArrayList<>();

            for(int i=0; i<size; i++){
                TreeNode x = q.remove();

                if(left){
                    innerList.add(x.val);
                } 
                else{
                    innerList.add(0, x.val);
                }
                

                if(x.left != null) q.add(x.left);
                if(x.right != null) q.add(x.right);
            }

            list.add(innerList);
            left = !left;
        }

        return list;
    }
}