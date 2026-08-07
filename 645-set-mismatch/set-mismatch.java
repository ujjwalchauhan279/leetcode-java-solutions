class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int set[] = new int[n];
        int ans[] = new int[2];
        int sum = 0;
        
        for(int ele:nums) sum += ele;

        for(int i=0; i<n; i++){
            if(set[nums[i]-1] == 1){
                ans[0] = nums[i];
            }
            set[nums[i]-1]++;
        }

        int total = (n * (n+1))/2;
        ans[1] = total - (sum - ans[0]);

        return ans;
    }
}