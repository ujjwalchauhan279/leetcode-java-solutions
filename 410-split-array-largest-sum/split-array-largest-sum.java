class Solution {
    public int ispossible(long page, int arr[]) {
		int student = 1;
		long  pageCount = 0;
		
		for (int i = 0; i<arr.length; i++) {
			if (pageCount + arr[i] <= page) {
				pageCount += arr[i];
			}
			else {
				student++;
				pageCount = arr[i];
			}
		}
		
		return student;
	}
    public int splitArray(int[] arr, int k) {
        if (k > arr.length)
			return - 1;
		int max = Integer.MIN_VALUE;
		long sum = 0;
		for (int ele: arr) {
			sum += ele;
			max = Math.max(max, ele);
		}
		
		long low = max;
		long high = sum;
		
		long ans = -1;
		
		while (low <= high) {
			long mid = low + (high - low)/2;
			if(ispossible(mid, arr) > k){
			    low = mid + 1;
			}
			else{
			    ans = mid;
			    high = mid - 1;
			}
		}
		return (int)ans;
    }
}
