class Solution {
    public List<Integer> findValidElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int left = nums[0];
        int right[] = new int[n];
        right[n-1] = nums[n-1];
        list.add(left);

        for(int i=n-2; i>=0; i--){
            if(nums[i] > right[i+1]){
                right[i] = nums[i];
            }
            else{
                right[i] = right[i+1];
            }
        }

        for(int i=1; i<n-1; i++){
            if(nums[i] > left || nums[i] > right[i+1]) list.add(nums[i]);
            if(nums[i] > left) left = nums[i];
        }

        if(n > 1) list.add(nums[n-1]);
        return list;
    }
}