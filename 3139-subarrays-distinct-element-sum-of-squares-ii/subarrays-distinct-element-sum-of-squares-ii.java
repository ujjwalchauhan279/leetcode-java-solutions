public class Solution {
    private static final int MOD = (int) (1e9) + 7;
    private int n;
    private long[] tree1;
    private long[] tree2;

    public int sumCounts(int[] nums) {
        n =nums.length;
        tree1 =new long[n+1];
        tree2 =new long[n+1];
        int max =0;
        for(int X :nums){
            if(X>max){
                max =X;
            }
        }
        int[] last =new int[max+1];
        long ans =0;
        long curr =0;
        for(int i =1;i<=n;i++){
            int x = nums[i - 1];
            int j = last[x];
            curr += 2 * (query(i) - query(j)) + (i - j);
            ans += curr;
            update(j + 1, 1);
            update(i + 1, -1);
            last[x] = i;
        }
        return (int) (ans % MOD);
    }

    int lowbit(int index) {
        return index & (-index);
    }

    void update(int index, int x) {
        int v = index * x;
        while (index <= n) {
            tree1[index] += x;
            tree2[index] += v;
            index += lowbit(index);
        }
    }

    long query(int index) {
        long res = 0;
        int p = index + 1;
        while (index > 0) {
            res += p * tree1[index] - tree2[index];
            index -= lowbit(index);
        }
        return res; 
    }
}