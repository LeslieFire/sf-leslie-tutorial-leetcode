/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
 // DFS 139 ms
var largestValues = function(root) {
    var maxes = []
    dfs(root, 0, maxes)
    return maxes
};

var dfs = function(root, level, maxes) {
    if (!root) return
    
    var val = root.val
    if (maxes.length == level){
        maxes.push(val)    // swift: append, python: append, js:push, java: add, c++:push_back
    }else{
        maxes[level] = Math.max(val, maxes[level]) // 用Math 的函数，得Math.xxx()
    }
    
    dfs(root.left, level+1, maxes)
    dfs(root.right, level+1, maxes)
}