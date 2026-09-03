class Solution {
    public boolean uniformArray(int[] nums1) {
        int even=0,odd=0;
        int min=Integer.MAX_VALUE;
        for(int x:nums1){
            if(min>x) min=x;
            if(x%2==0) even++;
            else odd++;
        }
        if(even==nums1.length || odd==nums1.length) return true;
        if(min%2!=0) return true;
        return false;
    }
}