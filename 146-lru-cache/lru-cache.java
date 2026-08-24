class Pair{
    int key;
    int value;
    Pair prev;
    Pair next;

    Pair(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    HashMap<Integer, Pair> map = new HashMap<>();
    Pair head = new Pair(0, 0);
    Pair tail = new Pair(0, 0);
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;

        head.next = tail; 
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Pair node = map.get(key);

        removeFromHead(node);
        addAtTail(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Pair node = map.get(key);
            node.value = value;
            removeFromHead(node);
            addAtTail(node);
        }
        else{
            Pair node = new Pair(key, value);
            map.put(key, node);
            addAtTail(node);

            if(map.size() > capacity){
                Pair remove = head.next;
                removeFromHead(remove);
                map.remove(remove.key);
            }
        }
    }
    void removeFromHead(Pair node){
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }
    void addAtTail(Pair node){
        node.prev = tail.prev;
        node.next = tail;

        tail.prev.next = node;
        tail.prev = node;
    } 

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */