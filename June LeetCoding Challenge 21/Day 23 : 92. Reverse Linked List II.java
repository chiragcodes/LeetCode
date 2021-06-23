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


/*  Approach:  

                                                   reverse
    Input: m = 4, n = 6                      m  <----------->  n
    
                  a   ->   b   ->   c   ->   d   ->   e   ->   f   ->   g   ->   h
                 head       
    
    
    i. Store preHead as parent of head to return (preHead.next) at last.
       It will return the updated list with new head at that position.

     
          0  ->   a   ->   b   ->   c   ->   d   ->   e   ->   f   ->   g   ->   h
       preHead   head


    ii. Loop prev till reaches position m - 1
    
                                            m                 n
         0  ->   a   ->   b   ->   c   ->   d   ->   e   ->   f   ->   g   ->   h
       preHead   head             prev
       


    iii. Reverse list from m to n
    
                                            m                 n
         0  ->   a   ->   b   ->   c   ->   d   ->   e   ->   f   ->   g   ->   h
       preHead   head             prev     curr     temp
       
    
        reverseHead = null
        
                                            d   ->   e   ->   f   ->   g
                                           curr     temp                   temp = curr.next
                                           
                                  revH  <-  d        e   ->   f   ->   g
                                   --      curr     temp                   curr.next = revH
                                           
                                        <-  d        e   ->   f   ->   g
                                   --      revH     curr                   revH = curr, curr = temp
                                   
                                        <-  d        e   ->   f   ->   g
                                   --      revH     curr     temp          temp = curr.next
                                   
                            -----------------------------------------------------------------------------------
                            
                                        <-   d   <-  e        f   ->   g
                                   --      revH     curr     temp           curr.next = revH
                                   
                                        <-   d   <-  e        f   ->   g
                                   --               revH     curr           revH = curr, curr = temp
                                   
                                        <-   d   <-  e        f   ->   g
                                   --               revH     curr     temp  temp = curr.next
                                   
                            -----------------------------------------------------------------------------------           
                                   
                                   
                                        <-   d   <-  e   <-   f        g
                                   --               revH     curr     temp    curr.next = revH
                                    
                                        <-   d   <-  e   <-   f        g
                                   --                        revH     curr    revH = curr, curr = temp
                                   
                                   
    
               Reversed sublist :  __   <-   d   <-  e   <-   f     <=>   f  ->  e  ->  d  -> __
    
    
    iv. Connect the reversed list


    
    
            
            
*/

class Solution {
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        
        int m = left, n = right;
        
        /*  Corner Case */
        
        if (head == null || head.next == null || m <= 0 || n <= 0 || m == n) {
            return head;
        }
        
        // to store the head index, to return the final updated head at this index.
        
        ListNode preHead = new ListNode(0);  
        preHead.next = head;
        
        // Traverse the list till position m. Position m -> index m-1 => loop till 0 to m-2.
        
        ListNode prev = preHead;
        
        for (int i = 0; i <= m-2; i++) {
            prev = prev.next;
        }
        
        // Reverse the list from position m to n.
        
        ListNode curr = prev.next;
        ListNode temp = null;
        
        ListNode reverseHead = null;
        
        for (int i = 0; i <= n-m; i++) {
            
            temp = curr.next;         // save next of current for next iteration
            curr.next = reverseHead;  // reset current to point back not forward
            
            reverseHead = curr;       // make current as head of new reverseHead list
            curr = temp;              // move to next node
            
        }
        
        
        // Connect the reversed list with the prev node (position m-1)
        
        prev.next.next = curr;
        prev.next = reverseHead;
        
     
    return preHead.next;
        
        
    }
}
