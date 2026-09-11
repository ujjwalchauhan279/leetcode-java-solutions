class Solution {
    public int[] findEvenNumbers(int[] digits) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = digits.length;
        int freq[] = new int[10]; 

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
                    int num = (i*100) + (j*10) + k;
                    list.add(num);
                }
                freq[j]++;
            }
            freq[i]++;
        }

        int m = list.size();
        int arr[] = new int[m];
        for(int i=0; i<m; i++){
            arr[i] = list.get(i);
        }

        return arr;
    }
}