class Solution {
    public String minWindow(String s, String t) {
        int freq[] = new int[256];

        for (int i = 0; i < t.length(); i++)
            freq[t.charAt(i)]++;

        int l = 0;
        int r = 0;
        int count = 0;
        int startIndex = -1;
        int minSize = Integer.MAX_VALUE;

        while (r < s.length()) {
            char ch = s.charAt(r);
            if (freq[ch] > 0) {
                count++;
            }
            freq[ch]--;

            while (count == t.length()) {
                if (r - l + 1 < minSize) {
                    minSize = r - l + 1;
                    startIndex = l;
                }

                freq[s.charAt(l)]++;
                if (freq[s.charAt(l)] > 0)
                    count--;
                l++;
            }

            r++;
        }

        return (startIndex == -1) ? "" : s.substring(startIndex, startIndex + minSize);
    }
}