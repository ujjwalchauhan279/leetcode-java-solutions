class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<List<Integer>> ansSet = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                int val = -(nums[i]+nums[j]);
                if(set.contains(val)){
                   List<Integer> innerList = new ArrayList<>(List.of(nums[i], nums[j], val));
                   Collections.sort(innerList);
                   ansSet.add(innerList); 
               }
                set.add(nums[j]);
            }
            set.clear();
        }

        for(List<Integer> li: ansSet){
            list.add(li);
        }

        return list;
    }
}