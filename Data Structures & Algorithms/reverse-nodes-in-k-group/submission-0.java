/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        if (k == 1) return head;
        ListNode p = head;
        int count = 1;
        while(count < k) {
            p = p.next;
            count++;
            if (p == null) {
                return head;
            }
        }
        ListNode nextHead = p.next;
        reverse(head, p);
        head.next = reverseKGroup(nextHead, k);
        return p;
    }
    private void reverse(ListNode head, ListNode tail) {
        ListNode p = head, q = head;
        ListNode prev = null;
        while(prev != tail) {
            p = p.next;
            q.next = prev;
            prev = q;
            q = p;
        }
    }
}
