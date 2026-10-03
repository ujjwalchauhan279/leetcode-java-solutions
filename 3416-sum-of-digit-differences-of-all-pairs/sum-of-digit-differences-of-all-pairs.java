class Solution {
    public long sumDigitDifferences(int[] nums) {
        int n = nums.length;
        long ans = 0;

        while(nums[0] != 0){
            int freq[] = new int[10];
            for(int i=0; i<n; i++){
                freq[nums[i] % 10]++;
            }

            for(int i=0; i<10; i++){
                ans += (long) freq[i] * (n - freq[i]);
            }

            for(int i=0; i<n; i++){
                nums[i] = nums[i]/10;
            }
        }

        return ans / 2;
    }
}