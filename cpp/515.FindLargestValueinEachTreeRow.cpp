#include <algorithm>
/**
 *  * Definition for a binary tree node.
 *   * struct TreeNode {
 *    *     int val;
 *     *     TreeNode *left;
 *      *     TreeNode *right;
 *       *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 *        * };
 *         */
class Solution {
public:
    vector<int> largestValues(TreeNode* root) {
        
        vector<int> ret; // 创建就初始化，又不是指针，这一点跟java很不一样
        
        dfs(root, ret, 0);
        
        return ret;
    }
   // &ret 引用传递，java默认就是传递引用 
    void dfs(TreeNode* node, vector<int> &ret, int level){
        if (node == NULL) return; // c++的NULL，对应java 的null，swift的nil，python的None
        
        int val = node->val;
        if (ret.size() == level){
            ret.push_back(val);
        }else{
            ret[level] = max(val, ret[level]);
        }
        
        dfs(node->left, ret, level+1);
        dfs(node->right, ret, level+1);
    }
};
