class Solution {
    public int[] constructRectangle(int area) {
        int ans[] = new int[2];

        int i = (int)Math.sqrt(area);
        while(true){
            if(area % i == 0){
                ans[0] = area/i;
                ans[1] = i;
                break;
            }
            i--;
        }

        return ans;
    }
}