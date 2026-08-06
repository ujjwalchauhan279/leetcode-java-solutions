class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                heap.add(matrix[i][j]);
                if(heap.size() > k) heap.remove();
            }
        }

        int ans = heap.peek();
        return ans;
    }
}