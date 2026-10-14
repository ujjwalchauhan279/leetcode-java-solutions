class Solution {
    public int evalRPN(String[] s) {
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<s.length; i++){
            String x = s[i];
            if(x.equals("+")){
                int b = st.pop();
                int a = st.pop();

                st.push(a + b);
            }
            else if(x.equals("*")){
                int b = st.pop();
                int a = st.pop();

                st.push(a * b);
            }
            else if(x.equals("-")){
                int b = st.pop();
                int a = st.pop();

                st.push(a - b);
            }
            else if(x.equals("/")){
                int b = st.pop();
                int a = st.pop();

                st.push(a / b);
            }
            else{
                int num = Integer.parseInt(x);
                st.push(num);
            }
        }

        return st.pop();
    }
}