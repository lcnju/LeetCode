// Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.

// get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
// put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.

// Follow up:
// Could you do both operations in O(1) time complexity?

// Example:

// LFUCache cache = new LFUCache( 2 /* capacity */ );

// cache.put(1, 1);
// cache.put(2, 2);
// cache.get(1);       // returns 1
// cache.put(3, 3);    // evicts key 2
// cache.get(2);       // returns -1 (not found)
// cache.get(3);       // returns 3.
// cache.put(4, 4);    // evicts key 1.
// cache.get(1);       // returns -1 (not found)
// cache.get(3);       // returns 3
// cache.get(4);       // returns 4

class LFUCache {

    class Node {
        int key;
        int value;
        int times;

        public String toString() {
            return key + ":" + value + ":" + times;
        }
    }

    private int capacity;
    private HashMap<Integer, LinkedHashSet<Node>> frequentMap;
    private HashMap<Integer, Node> dataMap;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        dataMap = new HashMap<>(capacity);
        frequentMap = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (!dataMap.containsKey(key)) {
            return -1;
        }
        Node data = dataMap.get(key);

        frequentMap.get(data.times).remove(data);
        if (frequentMap.get(data.times).isEmpty()) {
            frequentMap.remove(data.times);
        }
        data.times++;
        if (!frequentMap.containsKey(data.times)) {
            frequentMap.put(data.times, new LinkedHashSet<>(capacity));
        }
        frequentMap.get(data.times).add(data);
        return data.value;
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }

        if (dataMap.containsKey(key)) {
            Node data = dataMap.get(key);
            data.value = value;
            get(key);
            return;
        }

        if (dataMap.size() >= capacity) {
            int minFrequent = frequentMap.keySet().parallelStream().min(Integer::compareTo).get();
            Node useless = frequentMap.get(minFrequent).iterator().next();
            frequentMap.get(minFrequent).remove(useless);
            dataMap.remove(useless.key);
        }

        Node node = new Node();
        node.key = key;
        node.value = value;
        node.times = 1;

        dataMap.put(key, node);
        if (!frequentMap.containsKey(1)) {
            frequentMap.put(1, new LinkedHashSet<>(capacity));
        }
        frequentMap.get(1).add(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */