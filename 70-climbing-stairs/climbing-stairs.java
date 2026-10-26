class Solution {
    int dp[] = new int[46];
    public int climbStairs(int n) {
        if(n==1 || n==2) return n;
        if(dp[n] != 0) return dp[n];

        int ans = climbStairs(n-1) + climbStairs(n-2);
        dp[n] = ans;
        return ans;
    }
}