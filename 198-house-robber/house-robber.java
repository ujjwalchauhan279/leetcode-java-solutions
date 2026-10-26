class Solution {
    int dp[];
    public int helper(int i, int nums[]){
        if(i >= nums.length) return 0;
        if(dp[i] != -1) return dp[i];
        int pick = nums[i] + helper(i+2, nums);
        int skip = helper(i+1, nums);
        int ans = Math.max(pick, skip);
        dp[i] = ans;
        return ans;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(0, nums);
    }
}