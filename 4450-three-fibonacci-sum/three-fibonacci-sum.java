class Solution {
    public boolean threeFibonacciSum(int n) {
        int a = 0;
        int b = 1;

        while(true){
            int c = a+b;
            if(a+b+c == n) return true;
            if(a+b+c > n) return false;

            a = b;
            b = c;
        }
    }
}