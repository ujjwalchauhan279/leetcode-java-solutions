class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int mid = -1;
        int missing = -1;

        while(low <= high){
            mid = low + (high - low)/2;
            missing = arr[mid] - (mid + 1);
            if(missing < k) low = mid + 1;
            else high = mid - 1;
        }

        // arr[high] + more(missing)
        // arr[high] + (k - (arr[high] - (high + 1)))
        // k + high + 1
        return high + 1 + k;
    }
}