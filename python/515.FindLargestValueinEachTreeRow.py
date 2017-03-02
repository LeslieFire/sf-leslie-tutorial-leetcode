##########BFS--- 72ms#################
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
        maxes = []
        row = [root]
        while any(row):
            maxes.append(max(node.val for node in row))
            row = [kid for node in row for kid in (node.left, node.right) if kid]
        return maxes


#########DFS--- 222ms####################
class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        
        return [root.val] + map(max, *map(self.largestValues, (root.left, root.right))) if root else []

#########DFS--- 95ms#####################

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
