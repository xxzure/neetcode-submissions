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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode parent = l1, p = l1;
        while (l1 != null && l2 != null) {
            int sum = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val) / 10;
            l1.val = sum;
            parent = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null) {
            parent.next = l2;
        }
        l1 = parent.next;
        while(l1 != null) {
            int sum = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            l1.val = sum;
            parent = l1;
            l1 = l1.next;
        }
        if (carry != 0) {
            parent.next = new ListNode(carry);
        }
        return p;
    }
}
