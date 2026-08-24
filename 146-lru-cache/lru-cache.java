class Pair{
    int key;
    int value;

    Pair(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    ArrayList<Pair> list = new ArrayList<>();
    int n;
    public LRUCache(int capacity) {
        n = capacity;
    }
    
    public int get(int key) {
        for(int i=0; i<list.size(); i++){
            if(list.get(i).key == key){
                Pair remove = list.remove(i);
                list.add(remove);
                return remove.value;
            }
        }
        return -1;
    }
    
    public void put(int key, int value) {
        for(int i=0; i<list.size(); i++){
            if(list.get(i).key == key){
                Pair remove = list.remove(i);
                remove.value = value;
                list.add(remove);
                return;
            }
        }
        if(list.size() >= n){
            list.remove(0);
        }
        list.add(new Pair(key, value));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */