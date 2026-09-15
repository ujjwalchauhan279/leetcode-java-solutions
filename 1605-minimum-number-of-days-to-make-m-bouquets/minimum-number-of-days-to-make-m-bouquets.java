class Solution {
    public int ispossible(int bloomDay[], int day, int k){
        int ans = 0;
        int count = 0;

        for(int ele: bloomDay){
            if(ele <= day) count++;
            else{
                ans += count/k;
                count = 0;
            }
        }

        ans += count/k;
        return ans;

    }
    public int minDays(int[] bloomDay, int m, int k) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int ele: bloomDay){
            low = Math.min(low, ele);
            high = Math.max(high, ele);
        }

        int ans = -1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(ispossible(bloomDay, mid, k) >= m){
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return ans;
    }
}