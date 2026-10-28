class Solution {
    int dp[];
    public int helper(int i, int cost[]){
        if(i >= cost.length) return 0;
        if(dp[i] != -1) return dp[i];

        int jump1 = cost[i] + helper(i+1, cost);
        int jump2 = cost[i] + helper(i+2, cost);

        return dp[i] = Math.min(jump1, jump2);
    }
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(helper(0, cost), helper(1, cost));
    }
}