/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        
        while(q.size() > 0){
            int size = q.size();
            
            for(int i=0; i<size-1; i++){
                TreeNode pop = q.remove();
                
                if(pop.left !=  null) q.add(pop.left);
                if(pop.right !=  null) q.add(pop.right);
            }
            
            TreeNode x = q.remove();
            list.add(x.val);
            if(x.left !=  null) q.add(x.left);
            if(x.right !=  null) q.add(x.right);
        }
        
        return list;
    }
}