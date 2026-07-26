class LRUCache {

    class Node {
        int key, value;
        Node prev, next;
        Node(int k ,int v) {
            this.key = k;
            this.value = v;
        }
    }
    Map<Integer, Node> map = new HashMap<>();
    int capacity;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node n = map.get(key);
        move(n);
        return n.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            move(n);
            n.value = value;
        } else {
            if (map.size() == capacity) {
                Node delete = tail.prev;
                delete.prev.next = tail;
                tail.prev = delete.prev;
                map.remove(delete.key);
            }
            Node n = new Node(key, value);
            n.next = head.next;
            head.next.prev = n;
            head.next = n;
            n.prev = head;
            map.put(key, n);
        }
    }

    private void move(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        n.next = head.next;
        head.next.prev = n;
        head.next = n;
        n.prev = head;
    }
}
