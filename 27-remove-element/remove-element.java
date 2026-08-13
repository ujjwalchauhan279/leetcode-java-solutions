class Solution {
    public int removeElement(int[] nums, int val) {
        int ele = 0;
        for(int i=0; i<nums.length; i++){
            while(ele<nums.length && nums[ele] != val) ele++;

            if(nums[i]!=val && i > ele){
                int temp = nums[ele];
                nums[ele] = nums[i];
                nums[i] = temp;

                ele++;
            }
        }

        return ele;


    }
}