class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> startPq = new PriorityQueue<>();
        PriorityQueue<Integer> endPq = new PriorityQueue<>();

        int n = costs.length;
        long cost = 0;
        int i = 0;
        int j = n-1;
        while(k != 0){
            while(startPq.size() < candidates && i<=j) startPq.add(costs[i++]);
            while(endPq.size() < candidates && i<=j) endPq.add(costs[j--]);

            // if(startPq.size() == 0){
            //     while(k != 0){
            //         cost += endPq.remove();
            //         k--;
            //     }
            //     break;
            // }
            // if(endPq.size() == 0){
            //     while(k != 0){
            //         cost += startPq.remove();
            //         k--;
            //     }
            //     break;
            // }

            int startTop = (startPq.size() > 0)? startPq.peek(): Integer.MAX_VALUE;
            int endTop = (endPq.size() > 0)? endPq.peek(): Integer.MAX_VALUE;

            if(startTop <= endTop){
                cost += startPq.remove();
            }
            else{
                cost += endPq.remove();
            }

            k--;
        }

        return cost;
    }
}