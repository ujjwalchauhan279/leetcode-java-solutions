class Solution {
    public int totalNumbers(int[] digits) {
        HashSet<Integer> set = new HashSet<>();
        int n = digits.length;
        int freq[] = new int[10]; 
        int count = 0;

        for(int i=0; i<n; i++){
            freq[digits[i]]++;
        }

        for(int i=1; i<=9; i++){
            if(freq[i] == 0) continue;
            freq[i]--;
            for(int j=0; j<=9; j++){
                if(freq[j] == 0) continue;
                freq[j]--;
                for(int k=0; k<=8; k+=2){
                    if(freq[k] == 0) continue;
                    count++;
                    
                }
                freq[j]++;
            }
            freq[i]++;
        }

        return count;
    }
}