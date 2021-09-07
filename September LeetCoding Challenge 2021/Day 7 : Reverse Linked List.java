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
    public ListNode reverseList(ListNode head) {
        
    /* Iterative Solution */
        
    ListNode reverseHead = null;
    ListNode temp = null;
        
    while (head != null) {
        // save next from current
        temp = head.next;
        // reset current to point back not forward
        head.next = reverseHead;
        // move to next frame
        reverseHead = head;
        head = temp;
    }
        
    return reverseHead;
        
    }
}
