class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int ele: nums) set.add(ele);
        int count = 1;

        for(int ele: nums){
            if(!set.contains(count)) return count;
            count++;
        }

        return count;
    }
}