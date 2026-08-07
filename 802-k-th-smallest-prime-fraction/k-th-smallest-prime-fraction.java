class Triplet implements Comparable<Triplet>{
    int num;
    int den;
    float frac;

    Triplet(){}
    Triplet(int num, int den, float frac){
        this.num = num;
        this.den = den;
        this.frac = frac;
    }

    public int compareTo(Triplet t){
        return Float.compare(this.frac, t.frac);
    }
}

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        int answer[] = new int[2];
        PriorityQueue<Triplet> pq = new PriorityQueue<>(Collections.reverseOrder());

        int num = 0;
        int den = 0;
        float frac = 0f;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                num = arr[i];
                den = arr[j];
                frac = num/(float)den;
                pq.add(new Triplet(num, den, frac));

                if(pq.size() > k) pq.remove();
            }
        }

        Triplet top = pq.remove();
        answer[0] = top.num;
        answer[1] = top.den;

        return answer;

    }
}