class Solution {
    public int subarrayCount(int nums[], int mid){
        int currSum = 0;
        int count = 0;
        for(int ele: nums){
            currSum += ele;
            if(currSum > mid){
                count++;
                currSum = ele;
            }
        }
        count++;

        return count;
    }
    public int splitArray(int[] nums, int k) {
        int low = -1;
        int high = 0;

        for(int ele: nums){
            if(low < ele) low = ele;
            high += ele;
        }

        int ans = 0;
        while(low <= high){
            int mid = low + (high-low)/2;
            int count = subarrayCount(nums, mid);
            if(count <= k){
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