class Solution {
    public int findClosestNumber(int[] nums) {
        int min = Integer.MAX_VALUE;
        int ans = Integer.MIN_VALUE;

        for(int ele: nums){
            int positive = Math.abs(ele);
            if(min >= positive){
                if(min == positive) ans = Math.max(ans, ele);
                else ans = ele;
                min = positive;
            }
        }

        return ans;
    }
}