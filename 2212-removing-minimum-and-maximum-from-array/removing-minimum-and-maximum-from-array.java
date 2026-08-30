class Solution {
    public int minimumDeletions(int[] nums) {
        int max = 0;
        int min = 0;
        int n = nums.length;

        for(int i=0; i<n; i++){
            if(nums[i] > nums[max]) max = i;
            if(nums[i] < nums[min]) min = i;
        }

        int leftIdx = -1;
        int rightIdx = -1;
        if(min < max){
            leftIdx = min;
            rightIdx = max;
        }
        else{
            leftIdx = max;
            rightIdx = min;
        }

        int a = (leftIdx+1) + (n-rightIdx);
        int b = (rightIdx+1);
        int c = (n-leftIdx);

        return Math.min(Math.min(a,b), c);


    }
}