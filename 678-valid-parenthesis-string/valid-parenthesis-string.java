class Solution {
    Boolean dp[][];

    public boolean helper(String s, int n, int i, int count){
        if(count < 0) return false;

        if(i == n) {
            return count == 0;
        }

        if(dp[i][count] != null)
            return dp[i][count];

        if(s.charAt(i) == '(')
            return dp[i][count] = helper(s, n, i+1, count+1);

        else if(s.charAt(i) == ')')
            return dp[i][count] = helper(s, n, i+1, count-1);

        else {
            return dp[i][count] =
                helper(s, n, i+1, count+1) ||
                helper(s, n, i+1, count-1) ||
                helper(s, n, i+1, count);
        }
    }

    public boolean checkValidString(String s) {
        int n = s.length();
        dp = new Boolean[n][n+1];

        return helper(s, n, 0, 0);
    }
}