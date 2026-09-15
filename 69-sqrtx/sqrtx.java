class Solution {
    public long ispossible(long root){
        return root*root;
    }
    public int mySqrt(int x) {
        int low = 1;
        int high = x;
        int ans = 0;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(ispossible(mid) <= x){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return ans;
    }
}