class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for(int i=0; i<operations.length; i++){
            String s = operations[i];
            if(s.charAt(1) == '+') ans++;
            else ans--;
        }

        return ans;
    }
}