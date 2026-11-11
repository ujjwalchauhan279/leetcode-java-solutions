class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        List<Long> list = new ArrayList<>();
        Stack<Long> st = new Stack<>();

        for(int x: nums){
            long val = x;
            
            while(st.size() != 0 && st.peek() == val){
                val += st.pop();
            }

            st.push(val);
        }

        while(st.size() != 0){
            list.add((long)st.pop());
        }

        Collections.reverse(list);
        return list;
    }
}