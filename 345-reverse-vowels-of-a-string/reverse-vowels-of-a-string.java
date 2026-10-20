class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        int l = 0;
        int r = n-1;
        char[] str = s.toCharArray();

        while(l < r){
            while(l < r && (str[l] != 'a' &&
                            str[l] != 'e' && 
                            str[l] != 'i' && 
                            str[l] != 'o' && 
                            str[l] != 'u' &&
                            str[l] != 'A' &&
                            str[l] != 'E' && 
                            str[l] != 'I' && 
                            str[l] != 'O' &&
                            str[l] != 'U')) l++;
            while(l < r && (str[r] != 'a' &&
                            str[r] != 'e' && 
                            str[r] != 'i' && 
                            str[r] != 'o' && 
                            str[r] != 'u' &&
                            str[r] != 'A' &&
                            str[r] != 'E' && 
                            str[r] != 'I' && 
                            str[r] != 'O' &&
                            str[r] != 'U')) r--;

            char temp = str[l];
            str[l] = str[r];
            str[r] = temp;

            l++;
            r--;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) sb.append(str[i]);

        return sb.toString();
    }
}