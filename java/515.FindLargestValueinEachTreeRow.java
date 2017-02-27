/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
public class Solution {
    private static final int FIRST_LEVEL = 0;
    
    
    private List<Integer> extendArray(List<Integer> in, int size){
        while(in.size() < size){
            in.add(Integer.MIN_VALUE);
        }
        return in;
    }
    
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        
        Deque<TreeNodeProxy> stack = new ArrayDeque<TreeNodeProxy>();
        stack.push(new TreeNodeProxy(root, FIRST_LEVEL));
        
        while(!stack.isEmpty()){
            TreeNodeProxy tnp = stack.pop();
            TreeNode node = tnp.node;
            if (node == null){
                continue;
            }
            
            int level = tnp.level;
            int value = node.val;
            
            if (ret.size() < level + 1){
                ret = extendArray(ret, level + 1);
            }
            
            if (ret.get(level) < value){
                ret.set(level, value);
            }
            
            if (node.left != null) stack.push(new TreeNodeProxy(node.left, level + 1));
            if (node.right != null) stack.push(new TreeNodeProxy(node.right, level + 1));
        }
        
        return ret;
        
    }
}



class TreeNodeProxy {
    
    int level;
    TreeNode node;
    
    TreeNodeProxy(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
}