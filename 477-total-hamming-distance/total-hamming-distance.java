class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for(int i=0; i<32; i++){
            int one = 0;
            for(int j=0; j<n; j++){
                if(((nums[j] >> i) & 1) == 1) one++;
            }
            ans += one * (n - one);
        }

        return ans;
    }
}