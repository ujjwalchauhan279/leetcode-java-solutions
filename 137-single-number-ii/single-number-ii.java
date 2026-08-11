class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;

        for(int i=0; i<32; i++){
            int k = (1 << i);
            int ones = 0;
            for(int ele: nums){
                if((ele & k) != 0) ones++;
            }
            if((ones % 3 == 1)){
                ans = (ans | k);
            }
        }

        return ans;
    }
}