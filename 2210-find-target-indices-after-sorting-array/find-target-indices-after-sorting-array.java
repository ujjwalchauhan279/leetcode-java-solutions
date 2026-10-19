class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int n = nums.length;
        int lessThan = 0;
        int equalTo = 0;
        for(int i=0; i<n; i++){
            if(nums[i] < target) lessThan++;
            else if(nums[i] == target) equalTo++;
        }

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<equalTo; i++){
            list.add(lessThan + i);
        }

        return list;
    }
}