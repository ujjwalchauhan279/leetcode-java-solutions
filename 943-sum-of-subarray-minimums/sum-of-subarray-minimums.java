class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];
        long mod = 1000000007;

        for(int i=0; i<n; i++){
            while(st.size() > 0 && arr[st.peek()] > arr[i]) st.pop();

            if(st.size() == 0) left[i] = -1;
            else left[i] = st.peek();

            st.push(i);
        }

        st.clear();

        for(int i=n-1; i>=0; i--){
            while(st.size() > 0 && arr[st.peek()] >= arr[i]) st.pop();

            if(st.size() == 0) right[i] = n;
            else right[i] = st.peek();

            st.push(i);
        }

        long ans = 0;
        for(int i=0; i<n; i++){
            long x = (long)(i - left[i]) * (right[i] - i) % mod;
            ans = (ans + arr[i] * x) % mod;
        }

        return (int)ans;
    }
}