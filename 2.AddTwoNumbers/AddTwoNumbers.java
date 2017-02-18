/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        
        ListNode result = new ListNode(0);
        int carry = 0;
        int total = 0;
        ListNode p = l1;
        ListNode q = l2;
        ListNode r = result;
        while(p != null && q != null){
            total = p.val + q.val + carry;
            carry = total > 9 ? 1 : 0;
            r.next = new ListNode(total > 9 ? total % 10 : total);
            
            r = r.next;
            p = p.next;
            q = q.next;
        }
    
        while(p != null){
            total = carry + p.val;
            carry = total > 9 ? 1 : 0;
            r.next = new ListNode(total > 9 ? total % 10 : total);
            
            r = r.next;
            p = p.next;
        }
        
        while(q != null){
            total = carry + q.val;
            carry = total > 9 ? 1 : 0;
            r.next = new ListNode(total > 9 ? total % 10 : total);
            
            r = r.next;
            q = q.next;
        }
        
        if (carry != 0){
            r.next = new ListNode(carry);
        }
        
        return result.next;
    }
    
}