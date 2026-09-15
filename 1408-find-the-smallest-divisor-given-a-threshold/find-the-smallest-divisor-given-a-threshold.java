class Solution {
    public int ispossible(int divisor, int nums[]){
        int threshold = 0;
        for(int ele: nums){
            if(ele % divisor == 0) threshold += ele/divisor;
            else threshold += ele/divisor + 1;
        }

        return threshold;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;

        for(int ele: nums){
            max = Math.max(max, ele);
        }

        int low = 1;
        int high = max;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(ispossible(mid, nums) <= threshold){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }
}