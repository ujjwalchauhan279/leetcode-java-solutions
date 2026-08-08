class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = (int)Math.pow(2, nums.length);
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<n; i++){
            int x = i;
            List<Integer> list = new ArrayList<>();
            int j = 0;
            while(x != 0){
                if((x & 1) == 1){
                    list.add(nums[j]);
                }
                j++;
                x = x >> 1;
            }
            result.add(list);
        }

        return result;
    }
}