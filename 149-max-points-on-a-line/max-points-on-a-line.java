class Solution {
    public int maxPoints(int[][] points) {
        HashMap<Double, Integer> map;
        int n = points.length;
        int maxCount = 1;

        for(int i=0; i<n; i++){
            map = new HashMap<>();
            for(int j=0; j<n; j++){

                if(j==i) continue;

                int dy = points[j][1] - points[i][1];
                int dx = points[j][0] - points[i][0];

                double theta = Math.atan2(dy, dx);
                map.put(theta, map.getOrDefault(theta, 0)+1);
            }

            for(double key: map.keySet()){
                int freq = map.get(key) + 1;
                if(freq > maxCount) maxCount = freq;
            }
        }

        return maxCount;
    }
}