class Solution {
    public int ispossible(int capacity, int weights[]){
        int days = 0;
        int c = capacity;
        for(int ele: weights){
            c -= ele;
            if(c < 0){
                days++;
                c = capacity - ele;
            }
        }

        days++;
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int ele: weights){
            max = Math.max(max, ele);
            sum += ele;
        }

        int low = max;
        int high = sum;
        int ans = sum;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(ispossible(mid, weights) <= days){
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