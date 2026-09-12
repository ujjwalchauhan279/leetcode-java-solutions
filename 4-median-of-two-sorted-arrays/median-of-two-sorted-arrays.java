class Solution {
    public int[] merge(int nums1[], int nums2[]){
        int n1 = nums1.length;
        int n2 = nums2.length;

        int nums3[] = new int[n1+n2];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < n1 && j < n2){
            if(nums1[i] < nums2[j]) nums3[k++] = nums1[i++];
            else nums3[k++] = nums2[j++];
        }

        while(i < n1) nums3[k++] = nums1[i++];
        while(j < n2) nums3[k++] = nums2[j++];

        return nums3;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums3[] = merge(nums1, nums2);
        int n3 = nums3.length;

        if(n3 % 2 != 0){
            return nums3[n3/2];
        }
        return (nums3[n3/2 - 1] + nums3[n3/2])/2.0;
    }
}