class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int empty = numBottles;
        int drink = numBottles;

        while(empty >= numExchange){
            int x = empty / numExchange; 
            drink += x;
            empty += x;
            empty -= (x*numExchange);
        }

        return drink;
    }
}