class Solution {
    public int longestValidParentheses(String s) {
        int open = 0;
        int close = 0;
        int ans = 0;
        int n = s.length();

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '(') open++;
            else close++;

            if(open == close) ans = Math.max(ans, open+close);
            else if(close > open) open = close = 0;
        }

        open = close = 0;
        for(int i=n-1; i>=0; i--){
            char ch = s.charAt(i);
            if(ch == '(') open++;
            else close++;

            if(open == close) ans = Math.max(ans, open+close);
            else if(close < open) open = close = 0;
        }

        return ans;
    }
}