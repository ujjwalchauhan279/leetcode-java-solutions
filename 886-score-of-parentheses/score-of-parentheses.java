class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int x = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '(') st.push(0);
            else{
                if(st.peek() == 0){
                    st.pop();
                    st.push(1);
                }
                else{
                    x = 0;
                    while(st.size() > 0 && st.peek() != 0){
                        x += st.pop();
                    }
                    st.pop();
                    st.push(2 * x);
                } 
            }
        }

        int sum = 0;
        while(st.size() != 0) sum += st.pop();

        return sum;
    }
}