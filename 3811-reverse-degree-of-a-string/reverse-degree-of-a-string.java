class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        for(int i=0; i<s.length(); i++){
            int x = (s.charAt(i) - 'a');
            sum += (26 - x) * (i+1);
        }

        return sum;
    }
}