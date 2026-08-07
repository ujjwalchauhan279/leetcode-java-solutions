class Triplet implements Comparable<Triplet>{
    int ele;
    int row;
    int col;

    Triplet(){}
    Triplet(int ele, int row, int col){
        this.ele = ele;
        this.row = row;
        this.col = col;
    }

    public int compareTo(Triplet t){
        return this.ele - t.ele;
    }
}

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        int k = nums.size();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<k; i++){
            min = Math.min(min, nums.get(i).get(0));
            max = Math.max(max, nums.get(i).get(0));
            pq.add(new Triplet(nums.get(i).get(0), i, 0));
        }

        int ele = 0;
        int row = 0;
        int col = 0;
        int a = min;
        int b = max;
        while(true){
            Triplet top = pq.remove();
            ele = top.ele;
            row = top.row;
            col = top.col;

            if(max - ele < b - a){
                a = ele;
                b = max;
            }

            if(col == nums.get(row).size() - 1) break;
            int next = nums.get(row).get(col+1);
            max = Math.max(max, next);
            pq.add(new Triplet(next, row, col+1));
        }

        int ans[] = new int[2];
        ans[0] = a;
        ans[1] = b;

        return ans;
    }
}