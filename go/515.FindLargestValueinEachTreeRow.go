/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
import "math"
func largestValues(root *TreeNode) []int {
    ret := []int{}
    dfs(root, 0, &ret)
    return ret
}

// 参数传递是 copy的。所以要用指针
func dfs(root *TreeNode, level int, ret *[]int) {
    if root == nil {
        return 
    }
    
    val := root.Val
    if level == len(*ret) {
        *ret = append(*ret, val)  
    }else{
        (*ret)[level] = int(math.Max(float64(val), float64((*ret)[level])))  // 用着真麻烦
    }
    
    dfs(root.Left, level + 1, ret)
    dfs(root.Right, level + 1, ret)
}