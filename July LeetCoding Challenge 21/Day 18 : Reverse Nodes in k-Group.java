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
      
        
        /* 
        
            Good post : 
            https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/11440/Non-recursive-Java-solution-and-idea
            
        */
        
        
        ListNode start;
        
        if (head == null || head.next == null || k == 1) {
            
            // If list length = 1 or reverse element in group of 1,  return same list
            
            return head;
            
        }
        
        ListNode preHead = new ListNode(-1);   // to store the address to point to the head node
        preHead.next = head;
        
        start = preHead;
        
        //  Do until head != null  i.e.  list is not empty
        
        int count = 0;
        
        while (head != null) {
            
            count++;
            
            if (count % k == 0) {
                
                // Now, group of k is formed and end is head.next. 
                // It will return the head of updated list to start
                
                start = reverseList (start, head.next);
                
                head = start.next;  // point to new reverse group's head
                
            } else {
                
                head = head.next;   // just traverse till length of group k is formed
                
            }
            
        }
        
        
        return preHead.next;   // actual pointer to head.
        
    }
    
      
    
    
    /*  Helper function to reverse nodes
    
        -> Start and End will be exluded, nodes between them will be reversed
        
           eg:  1  a  b  c  5  ->  1  c  b  a  5
                   
           curr will traverse from a to c   (in between elements and reversing them)
                 
    */
    
    private ListNode reverseList (ListNode start, ListNode end) {
        
        // Nodes between start and end needs to be reversed excluding corners start/end
        
        ListNode prev = start;
        ListNode curr = prev.next;
        
        ListNode next, first;
        
        first = curr;
        
        while (curr != end) {
            
            next = curr.next;             //  a (prev)   -->   b (curr)  -->   c (next)
            curr.next = prev;             //  a (prev)   <--   b (curr)  -->   c (next)  
            prev = curr;  curr = next;    //  a (    )   <--   b (prev)  -->   c (curr)
            
        }
        
        /*
        
           start     first
           
           prev      curr      next                end                                       prev   curr/end
        
            1   -->   2   -->   3   -->   4   -->   5     =>    1         2   <--   3   <--   4   -->   5
                                                                :         :                   ^         ^
                                                                :.........:...................:         :
                                                                          :                             :
                                                                          :.............................:
                                                                          
        =>  1   -->   4   -->   3   -->   2   -->   5       
        
                                                                          
        */
        
        start.next = prev;
        first.next = curr;
        
        return first;
        
    }
    
    
    
    
}
