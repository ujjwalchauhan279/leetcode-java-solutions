class Solution {
    public void helper(TreeNode root, int targetSum, List<Integer> innerList, List<List<Integer>> list){
        if(root == null) return;

        if(root.left == null && root.right == null){
            innerList = new ArrayList<>(innerList);
            innerList.add(root.val);
            targetSum -= root.val;
            
            if(targetSum == 0){
                list.add(innerList);
            }
            
            
        }

        innerList.add(root.val);
        targetSum -= root.val;

        helper(root.left, targetSum, innerList, list);
        helper(root.right, targetSum, innerList, list);

        innerList.remove(innerList.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> innerList = new ArrayList<>();

        helper(root, targetSum, innerList, list);

        return list;
    }
}