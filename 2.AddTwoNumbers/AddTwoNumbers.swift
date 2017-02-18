/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public var val: Int
 *     public var next: ListNode?
 *     public init(_ val: Int) {
 *         self.val = val
 *         self.next = nil
 *     }
 * }
 */
class Solution {
    func addTwoNumbers(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {
        let result = ListNode(0)
        var r = result
        var carry = 0
        var p: ListNode? = l1
        var q: ListNode? = l2
        while (p != nil || q != nil || carry != 0) {
            let total = (p != nil ? p?.val : 0)! + (q != nil ? q?.val : 0)! + carry
            carry = total / 10
            r.next = ListNode(total % 10)
            r = r.next!
            
            if let pp = p {
                p = p?.next
            }
            if let qq = q {
                q = q?.next
            }
        }
        return result.next
    }
}