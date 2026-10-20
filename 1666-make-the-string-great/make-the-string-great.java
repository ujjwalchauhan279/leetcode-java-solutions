class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        int n = s.length();

        for(int i=s.length()-1; i>=0; i--){
            char ch = s.charAt(i);
            if(st.size() > 0 && (Math.abs(st.peek() - ch)) == 32) st.pop();
            else st.push(ch);
        }

        while(st.size() != 0) sb.append(st.pop());

        return sb.toString();
    }
}