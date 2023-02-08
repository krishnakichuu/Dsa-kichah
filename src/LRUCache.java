import java.util.HashMap;
import java.util.Map;

class LRUCache {
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    Map<Integer,Node> map = new HashMap<>();
    int capacity;

    class Node{
        int key;
        int val;
        Node pre,next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }


    private void remove(Node node){
        map.remove(node.key);
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }


    private void insert(Node node){

        map.put(node.key,node);
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre =head;

    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
         if(map.containsKey(key)){
           var node = map.get(key);
           remove(node);
           insert(node);
           return node.val;
         }
         else
             return -1;
    }

    public void put(int key, int value) {
         if(map.containsKey(key))
             remove(map.get(key));
         if (map.size() == capacity)
             remove(tail.pre);

         insert(new Node(key,value));
    }
}
