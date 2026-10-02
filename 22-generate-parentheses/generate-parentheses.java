class Solution {
    public void helper(int n, int open, int close, String s, List<String> list){
        if(open == n && close == n){
            list.add(s);
            return;
        }

        if(open < n){
            helper(n, open+1, close, s+"(", list);
        }
        if(close < open){
            helper(n, open, close+1, s+")", list);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(n, 0, 0, "", list);

        return list;
    }
}