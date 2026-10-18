class MinStack {
    Stack<Long> st = new Stack<>();
    Stack<Long> minStack = new Stack<>();

    public MinStack() {
    }
    
    public void push(int value) {
        long val = (long)value;
        st.push(val);

        if(minStack.size() == 0 || val <= minStack.peek()){
            minStack.push(val);
        }
    }
    
    public void pop() {
        long val = st.pop();
        if(val == minStack.peek()) {
            minStack.pop();
        }
    }
    
    public long top() {
        return st.peek();
    }
    
    public long getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */