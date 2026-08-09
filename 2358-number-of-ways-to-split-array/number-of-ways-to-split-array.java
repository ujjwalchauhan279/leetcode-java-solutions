class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        int count = 0;
        long prefixSum = 0;
        long totalSum = 0;
        for(int ele: nums) totalSum += ele;

        for(int i=0; i<n-1; i++){
            prefixSum += nums[i];
            if(prefixSum >= (totalSum - prefixSum)) count++;
        }

        return count;
    }
}