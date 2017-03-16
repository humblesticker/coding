/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
    int walk(TreeNode* node, string s) {
        if(node == nullptr) return 0;
        
        s += to_string(node->val);
        if(node->left == nullptr && node->right == nullptr) { return stoi(s); }
        
        return walk(node->left, s) + walk(node->right, s);
    }
public:
    int sumNumbers(TreeNode* root) {
        return walk(root, "");
    }
};