# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        ret = []
        self.dfs(root, 0, ret)
        
        return ret
    
    def dfs(self, node, level, ret):
        if node == None:
            return None
        
        val = node.val
        if len(ret) == level:
            ret.append(val)
        else:
            ret[level] = max(ret[level], val)
            
        self.dfs(node.left, level+1, ret)
        self.dfs(node.right, level+1, ret)
        
        return None