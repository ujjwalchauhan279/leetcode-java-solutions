class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        HashSet<List<Integer>> ansSet = new HashSet<>();
        HashSet<Long> set = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    long sum = (long)nums[i] + nums[j] + nums[k];
                    long rem = (long)target - sum;
                    if(set.contains(rem)){
                        List<Integer> innerList = new ArrayList<>(List.of(nums[i], nums[j], nums[k], (int)rem));
                        Collections.sort(innerList);
                        ansSet.add(innerList);
                    }
                    set.add((long)nums[k]);
                }
                set.clear();
            }
        }

        for(List<Integer> li: ansSet){
            list.add(li);
        }

        return list;
    }
}