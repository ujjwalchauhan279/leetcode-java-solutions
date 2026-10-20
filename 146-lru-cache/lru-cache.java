class LRUCache {
    int capacity;
    HashMap<Integer, Integer> map = new HashMap<>();
    Deque<Integer> dq = new ArrayDeque<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        dq.remove(key);
        dq.addLast(key);

        return map.get(key);
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
            dq.remove(key);
        }
        if(map.size() == capacity) map.remove(dq.removeFirst());

        map.put(key, value);
        dq.addLast(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */