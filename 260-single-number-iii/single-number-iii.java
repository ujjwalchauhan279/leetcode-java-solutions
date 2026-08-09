class Solution {
    public int[] singleNumber(int[] nums) {
        int ans[] = new int[2];
        int XOR = 0;

        for(int ele: nums) XOR ^= ele;

        int k = 0;
        while(XOR != 0){
            if((XOR & 1) == 1){
                break;
            }
            k++;
            XOR >>= 1;
        }

        int xor1 = 0;
        int xor2 = 0;

        for(int ele: nums){
            if((ele & (1 << k)) == 0) xor1 ^= ele;
            else xor2 ^= ele;
        }
        
        ans[0] = xor1;
        ans[1] = xor2;
        return ans;
    }
}