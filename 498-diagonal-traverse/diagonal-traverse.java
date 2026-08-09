class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans[] = new int[m * n];

        int k = 0;
        int i = 0;
        int j = 0;
        boolean upward = true;
        while (i<m && j<n) {
            //upward
            if (upward) {
                ans[k++] = mat[i][j];
                i--;
                j++;

                if (j == n) {
                    i += 2;
                    j--;
                    upward = false;
                }
                if (i < 0) {
                    i = 0;
                    upward = false;
                }
            }
            // downward
            else {
                ans[k++] = mat[i][j];
                i++;
                j--;

                if (i == m) {
                    i--;
                    j += 2;
                    upward = true;
                }
                if (j < 0) {
                    j = 0;
                    upward = true;
                }
            }
        }

        return ans;
    }
}