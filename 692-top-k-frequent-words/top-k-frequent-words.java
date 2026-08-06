class Doublet implements Comparable<Doublet>{
    String str;
    int freq;

    Doublet(){}
    Doublet(String str, int freq){
        this.str = str;
        this.freq = freq;
    }

    public int compareTo(Doublet d){
        if(this.freq == d.freq) return d.str.compareTo(this.str);
        return this.freq - d.freq;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> list = new ArrayList<>();
        PriorityQueue<Doublet> pq = new PriorityQueue<>();
        HashMap<String, Integer> map = new HashMap<>();

        for(String str: words){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        int freq = 0;
        for(String str: map.keySet()){
            freq = map.get(str);

            pq.add(new Doublet(str, freq));

            if(pq.size() > k) pq.remove();
        }

        Doublet top;
        while(pq.size() > 0){
            top = pq.remove();

            list.add(top.str);
        }
        
        Collections.reverse(list);
        return list;
    }
}