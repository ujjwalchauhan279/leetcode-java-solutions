class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int maxCount = 1;
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int count = 2;
                int dy = (points[j][1] - points[i][1]);
                int dx = (points[j][0] - points[i][0]);

                for(int k=j+1; k<n; k++){
                    int dy_ = (points[k][1] - points[i][1]);
                    int dx_ = (points[k][0] - points[i][0]);

                    if((dx * dy_) == (dx_ * dy)){
                        count++;
                    }
                }
                if(count > maxCount) maxCount = count;
            }
        }

        return maxCount;
    }
}