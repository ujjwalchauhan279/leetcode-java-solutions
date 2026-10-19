class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();

        for(int x: arr){
            while(st.size() > 0 && st.peek() > 0 && x < 0){
                int sum = st.peek() + x;
                if(sum > 0){
                    x = 0;
                }
                else if(sum < 0){
                    st.pop();
                }
                else{
                    st.pop();
                    x = 0;
                }
            }
            if(x != 0) st.push(x);
        }

        int ans[] = new int[st.size()];

        for(int i=ans.length-1; i>=0; i--){
            ans[i] = st.pop();
        }

        return ans;
    }
}