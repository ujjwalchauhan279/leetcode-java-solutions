class Solution {
    public void generate(List<String> ans, int n, int open, int close, String curr){
        if(open==n && close==n){
            ans.add(curr);
            return;
        }
        if(open<n){
            generate(ans, n, open+1, close, curr+"(");
        }
        if(close<open){
            generate(ans, n, open, close+1, curr+")");
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(ans, n, 0, 0, "");
        return ans;
    }
}