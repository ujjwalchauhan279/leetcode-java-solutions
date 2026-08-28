class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        for(int i=0; i<m; i++){
            int low = 0;
            int high = n-1;

            while(low <= high){
                int mid = low + (high - low)/2;

                if(grid[i][mid] < 0){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }

            count += n-low;
        }
        return count;
        
    }
}