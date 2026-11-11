class Solution {
    public int scoreDifference(int[] nums) {
        int score = 0;
        boolean flag = true;

        for(int i=0; i<nums.length; i++){
            if((nums[i] % 2 != 0)) flag = !flag;
            if((i % 6 == 5)) flag = !flag;


            if(flag){
                score += nums[i];
            }
            else{
                score -= nums[i];
            }
            
        }

        return score;
    }
}