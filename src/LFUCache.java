import java.util.HashMap;
import java.util.Map;

class LFUCache {

    Node head = new Node(0,0,0);
    Node tail = new Node(0,0,0);
    Map<Integer,Node> map = new HashMap<>();

    int capacity;
    class Node{
        int key;
        int val;
        int frq;

        Node pre,next;

        public Node(int key, int val , int frq) {
            this.key = key;
            this.val = val;
            this.frq = frq;
        }
    }

    public LFUCache(int capacity) {

        head.next = tail;
        tail.pre= head;
        this.capacity = capacity;


    }

    public int get(int key) {
        if (map.containsKey(key)){
            var node = map.get(key);
            var newfrq = node.frq;
            var newnode = new Node(node.key,node.val,newfrq+1);
            remove(node);
            findwere(newnode);
            return node.val;
        }
        else
            return -1;

    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            var frq = map.get(key).frq;
            remove(map.get(key));
            findwere(new Node(key,value,frq+1));
            return;
        }
        if (capacity == map.size())
            remove(tail.pre);


        findwere(new Node(key,value,1));


    }

    private void findwere(Node node){


        if(head.next == tail)
            insert(tail,node);
        else{
            var cur = head.next;
            while(cur != tail) {
                if (cur.frq > node.frq) {
                    cur = cur.next;
                }else if(cur.frq == node.frq){
                    break;
                }
                else
                    break;
            }
            insert(cur,node);
        }
    }

    private void remove(Node node){

        map.remove(node.key);
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    private void insert(Node beforeNode, Node newNode){

        map.put(newNode.key,newNode);
        newNode.next = beforeNode;
        newNode.pre = beforeNode.pre;
        beforeNode.pre.next = newNode;
        beforeNode.pre = newNode;

    }

}