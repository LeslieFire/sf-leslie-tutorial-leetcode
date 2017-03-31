public class LRUCache {
    
    private int capacity;
    private Map<Integer, DLinkedNode> cache;
    private DLinkedNode head;
    private DLinkedNode tail;
    private static long count;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        
        head = new DLinkedNode();
        tail = new DLinkedNode();
        
        head.pre = null;
        head.next = tail;
        tail.pre = head;
        tail.next = null;
    }
    
    private void remove(DLinkedNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        
        cache.remove(node.key);
    }
    
    private void enqueue(DLinkedNode node){
        head.next.pre = node;
        node.next=  head.next;
        
        head.next = node;
        node.pre = head;
        
        cache.put(node.key, node);
    }
    
    private void dequeue(){
        DLinkedNode node = tail.pre;
        node.pre.next = tail;
        tail.pre = node.pre;
        
        cache.remove(node.key);
    }
    
    
    public int get(int key) {
        int ret = -1;
        if (cache.containsKey(key)){
            DLinkedNode node = cache.get(key);
            
            remove(node);
            enqueue(node);
            
            ret = node.value;
        }
        
        return ret;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)){
            remove(cache.get(key));
        }else if ( cache.size() >= capacity ){
            dequeue();
        }
        
        DLinkedNode node = new DLinkedNode();
        node.key = key;
        node.value = value;
        enqueue(node);
    }
    
    private class DLinkedNode{
        int key;
        int value;
        
        DLinkedNode pre;
        DLinkedNode next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
