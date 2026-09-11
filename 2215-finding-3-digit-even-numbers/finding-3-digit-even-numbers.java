class Solution {
    public int[] findEvenNumbers(int[] digits) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int n = digits.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    if(i == j || j == k || i == k) continue;
                    int num = (digits[i]*100) + (digits[j]*10) + (digits[k]);
                    if((num % 2 == 0) && (num >= 100 && num <= 999)) set.add(num);
                }
            }
        }
        for(int x: set) list.add(x);
        Collections.sort(list);

        int m = list.size();
        int arr[] = new int[m];
        for(int i=0; i<m; i++){
            arr[i] = list.get(i);
        }

        return arr;
    }
}