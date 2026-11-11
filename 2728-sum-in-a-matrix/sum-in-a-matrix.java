class Solution {
    public int matrixSum(int[][] nums) {
        int score = 0;
        int m = nums.length;
        int n = nums[0].length;

        for(int x[]: nums){
            Arrays.sort(x);
        }

        for(int j=0; j<n; j++){
            int max = -1;

            for(int i=0; i<m; i++){
                max = Math.max(max, nums[i][j]);
            }

            score += max;
        }

        return score;
    }
}