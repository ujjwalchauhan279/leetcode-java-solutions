class Solution {
    public int max(int nums[], int end) {
        int max = -1;
        for(int i=0; i<=end; i++) {
            if (max < nums[i])
                max = nums[i];
        }
        return max;
    }

    public int min(int nums[] , int start) {
        int min = Integer.MAX_VALUE;
        for(int i=start; i<nums.length; i++) {
            if (min > nums[i])
                min = nums[i];
        }
        return min;
    }

    public int firstStableIndex(int[] nums, int k) {
        for(int i=0; i<nums.length; i++){
            int max = max(nums, i);
            int min = min(nums, i);
            if(max-min<=k) return i;
        }
        return -1;
    }
}