class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean arr[] = new boolean[n+1];

        for(int ele:nums){
            if(ele > 0 && ele < n+1) arr[ele] = true;
        }

        for(int i=1; i<n+1; i++){
            if(!arr[i]) return i;
        }

        return n+1;
    }
}