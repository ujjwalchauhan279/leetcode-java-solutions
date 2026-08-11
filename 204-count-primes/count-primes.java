class Solution {
    public int countPrimes(int n) {
        int arr[] = new int[n+1];
        int count = 0;
        for(int i=2; i<n; i++){
            if(arr[i] == 0){
                count++;
                for(int j = 2*i; j<n; j+=i){
                    arr[j]++;
                }
            }
        }

        return count;
    }
}