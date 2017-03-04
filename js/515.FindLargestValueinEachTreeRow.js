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
// BFS 195 ms
var largestValues = function(root) {
    
    var ret = [];
    if (!root) return ret;
    
    var queue = [root];
    
    while (queue.length > 0) {
        var size = queue.length;
        var max = Number.MIN_SAFE_INTEGER;
        for (var i = 0; i < size; ++i){
            var node = queue.shift();
            if (node.val > max) max = node.val;
            if (node.right) queue.push(node.right);
            if (node.left) queue.push(node.left);
        }
        
        ret.push(max);
    }
    return ret;
};
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