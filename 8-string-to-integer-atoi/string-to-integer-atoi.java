class Solution {
    public int myAtoi(String s) {
        boolean neg = false;
        long x = 0;
        boolean started = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ' && !started)
                continue;
            else if (ch == '-' && !started) {
                started = true;
                neg = true;
            } else if (ch == '+' && !started) {
                started = true;
                continue;
            } else if (ch >= '0' && ch <= '9') {
                x = (x * 10) + (ch - '0');
                if(!started) started = true;

                if(x > Integer.MAX_VALUE) {
                    return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            } else
                break;
        }

        if (neg)
            x = -x;

        return (int) x;
    }
}