class Solution {
    public int removeDuplicates(int[] nums) {
        int curr = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[curr] != nums[i]){
                curr++;
                int temp = nums[curr];
                nums[curr] = nums[i];
                nums[i] = temp;
            }
        }

        return curr + 1;
    }
}