//Morris Traversal

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null){
                //find predecessor
                TreeNode p = curr;
                p = curr.left;
                while(p.right != null && p.right != curr) p = p.right;

                //linking
                if(p.right == null){
                    p.right = curr;
                    curr = curr.left;
                }
                //unlinking
                else{
                    p.right = null;
                    list.add(curr.val);
                    curr = curr.right;
                }
            }
            else{
                list.add(curr.val);
                curr = curr.right;
            }
        }

        return list;
    }
}