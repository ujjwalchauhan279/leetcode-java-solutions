class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int k = 0;
        int l = 0;

        for (int i = 0; i < n - 3; i++) {
            while (i != 0 && i < n && nums[i] == nums[i - 1])
                i++;
            for (int j = i + 1; j < n - 2; j++) {
                while (j != i+1 && j < n && nums[j] == nums[j - 1])
                    j++;

                k = j + 1;
                l = n - 1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        list.add(new ArrayList<>(List.of(nums[i], nums[j], nums[k], nums[l])));
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1])
                            k++;
                        while (k < l && nums[l] == nums[l + 1])
                            l--;
                    } else if (sum < target)
                        k++;
                    else
                        l--;
                }
            }
        }

        return list;
    }
}