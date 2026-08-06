class Doublet implements Comparable<Doublet>{
    char ch;
    int freq;
    Doublet(){}
    Doublet(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }

    public int compareTo(Doublet d){
        if(this.freq == d.freq) return this.ch - d.ch;
        return d.freq - this.freq;
    }
}

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Doublet> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int freq = 0;
        for(char ch: map.keySet()){
            freq = map.get(ch);
            pq.add(new Doublet(ch, freq));
        }

        Doublet top;
        String str;
        while(pq.size() != 0){
            top = pq.remove();
            str = String.valueOf(top.ch);
            freq = top.freq;

            sb.append(str.repeat(freq));
        }

        return sb.toString();

    }
}