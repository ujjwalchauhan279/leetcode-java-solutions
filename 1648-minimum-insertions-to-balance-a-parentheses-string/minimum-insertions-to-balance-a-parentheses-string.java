class Solution {
    public int minInsertions(String s) {
        int count = 0;
        int ans = 0;
        int n = s.length();

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                count++;
            }
            else{
                if(count > 0) count--;
                else ans++;

                if(i+1 < n && s.charAt(i+1) == ')') i++;
                else ans++;
            }
        }

        return ans + (count * 2);
    }
}