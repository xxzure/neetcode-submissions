/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node fakeNode = new Node(-1);
        Map<Node, Node> map = new LinkedHashMap<>();
        Map<Node, Node> newOld = new HashMap<>();
        Node p = head;
        while(p != null) {
            map.put(p, p.random);
            p = p.next;
        }
        p = fakeNode;
        for (Node n : map.keySet()) {
            Node temp = new Node(n.val);
            newOld.put(n, temp);
            p.next = temp;
            p = p.next;
        }
        for (Node n : map.keySet()) {
            Node newNode = newOld.get(n);
            newNode.random = newOld.get(n.random);
        }
        return fakeNode.next;
    }
}
