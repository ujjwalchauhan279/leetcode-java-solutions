class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int j = 0;
        int k = 0;

        for(int i=0; i<n; i++){
            while(i != 0 && i < n && nums[i] == nums[i-1]) i++;

            j = i+1;
            k = n-1;

            while(j < k){
                int sum =  nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    list.add(new ArrayList<>(List.of(nums[i], nums[j], nums[k])));
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;
                }
                else if(sum < 0){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return list;
    }
}