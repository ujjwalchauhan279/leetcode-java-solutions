class Solution {
    public int findKthPositive(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();

        for(int ele: arr) set.add(ele);

        int x = 1;
        int count = 0;
        while(true){
            if(!set.contains(x)){
                count++;
            }
            if(count == k){
                break;
            }
            x++;
        }

        return x;
    }
}