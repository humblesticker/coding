/*
range
    if(pos is not in range) return null
    else add node with pos, pos++ if(pos >= preorder length) return node;
    
    child = next value in preorder
    node.left = range(start, pos, child)
    node.right = range(pos+1, end, child)

range(0, len, pos)
*/ 
public class BinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int[] preorder; int[] inorder; int root;
    int find(int pos) {
        for(int i=0; i<inorder.length; i++) if(inorder[i] == preorder[pos]) return i;
        return -1; //NA
    }
    
    TreeNode build(int start, int end, int pos) {
        if(end <= start) return null;
        TreeNode node = new TreeNode(preorder[root++]);
        if(root >= preorder.length) return node;

        int child = find(root);
        node.left = build(start, pos, child);
        node.right = build(pos+1, end, child);

        return node;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) return null;
        root = 0; this.preorder = preorder; this.inorder = inorder;
        return build(0, inorder.length, find(root));
    }
}