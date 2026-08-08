class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        for(int i=0; i<31; i++){
            int LSB = (n & 1);
            ans = ans | LSB;
            ans = ans << 1;
            n = n >> 1;
        }

        return ans;
    }
}