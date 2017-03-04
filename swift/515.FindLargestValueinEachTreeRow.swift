/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public var val: Int
 *     public var left: TreeNode?
 *     public var right: TreeNode?
 *     public init(_ val: Int) {
 *         self.val = val
 *         self.left = nil
 *         self.right = nil
 *     }
 * }
 */
#########BFS   69ms #########
class Solution {
     

    func largestValues(_ root: TreeNode?) -> [Int] {
        var maxes = [Int]()  // 创建一个数组，声明+初始化
        var row = [root]
        
        while row.count > 0 {
            var rowValue = [Int]()
            for r in row {
                if let node = r{
                    rowValue.append(node.val)
                }
            }
            if let m = rowValue.max(){  
                maxes.append(m)
            }else{  // 如果连最大值都没有，那只能说明这一层都是nil，break掉
                break
            }
            
            var nextRow = [TreeNode?]()
            for r in row {
                if let node = r {
                    nextRow.append(node.left)
                    nextRow.append(node.right)
                }
            }
            
            row = nextRow
            
        }
        
        return maxes
    }

}


 #######DFS  72ms##########
class Solution {
    var maxes = [Int]()  // 创建一个数组，声明+初始化 

    func largestValues(_ root: TreeNode?) -> [Int] {
          // 没有；
        findLargest(root, 0)
        
        return maxes
    }
    
    // 参数传递是这样写的  level：Int
    func findLargest(_ root: TreeNode?, _ level: Int){
        if let node = root { // unwrap
            var value = node.val
            if maxes.count == level{
                maxes.append(value)
            }else{
                maxes[level] = max(value, maxes[level])
            }
            
            findLargest(node.left, level + 1)
            findLargest(node.right, level + 1)
        }
    }
}