/**
 * 
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
    
    // js中 function就是一个功能完整的对象
    var result = new ListNode(0);
    var r = result;
    var carry = 0;
    
    while (l1  || l2 || carry) {
        total = (l1 ? l1.val : 0) + (l2 ? l2.val : 0) + carry;
        // 只有Number一种数值类型，取整得专门搞
        carry = parseInt(total / 10);
        r.next = new ListNode(total % 10);
        
        r = r.next;
        
        l1 = l1 ? l1.next : l1;
        l2 = l2 ? l2.next : l2;
    }
    return result.next;
};