class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele: nums){
            if(ele % k == 0)
                set.add(ele);
        }
        int target = k;
        while(set.contains(target)){
            target += k;
        }
        return target;
    }
}
