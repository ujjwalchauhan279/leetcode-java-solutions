class Pair{
    int sum;
    int count;
    Pair(int sum, int count){
        this.sum = sum;
        this.count = count;
    }
}

class Solution {
    static int ans;
    public Pair helper(TreeNode root){
        if(root == null) return new Pair(0, 0);

        Pair left = helper(root.left);
        Pair right = helper(root.right);

        int sum = root.val + left.sum + right.sum;
        int count = 1 + left.count + right.count;

        if(root.val == (sum/count)) ans++;

        return new Pair(sum, count);
    }
    public int averageOfSubtree(TreeNode root) {
        ans = 0;

        helper(root);

        return ans;
    }
}