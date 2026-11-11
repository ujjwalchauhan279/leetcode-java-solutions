class Solution {
    public int sum(int n){
        int digitSum = 0;
        int squareSum = 0;

        while(n != 0){
            int r = n % 10;

            digitSum += r;
            squareSum += r*r;

            n /= 10;
        }

        return squareSum - digitSum;
    }
    public boolean checkGoodInteger(int n) {
        return (sum(n) >= 50)? true: false;
    }
}