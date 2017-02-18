/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
    
    var result ListNode
    r := &result
    carry := 0
    
    // 竟然不能直接 l1 || l2 || carry 
    // 可能这就是go的好处，虽然代码变长了。有待验证。
    for l1 != nil || l2 != nil || carry != 0 {
        
        // 竟然不让用 ？：运算符
        v1 := 0
        if l1 != nil {
            v1 = l1.Val
        }
        
        v2 := 0
        if l2 != nil {
            v2 = l2.Val
        }
        total := v1 + v2 + carry
        carry = total / 10
        
        r.Next = &ListNode{total % 10, nil} // 这里居然用{}来初始化，逆天
        r = r.Next
        
        if l1 != nil {
            l1 = l1.Next
        }
        if l2 != nil {
            l2 = l2.Next
        }
    }
    return result.Next
}