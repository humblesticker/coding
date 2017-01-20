/*
map(int, TreeNode)
loop node in preorder
    if node's inorder pos is left of prev node's inorder pos
        set prev.left to cur node, add to map
    else 
        set prev in inorder's right to cur, add to map
*/ 
import java.util.*;

public class BinaryTree {
    class TreeNode {
        int val; TreeNode left; TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int find(int val, int[] inorder) {
        for(int i=0; i<inorder.length; i++) if(inorder[i] == val) return i;
        return -1; //NA
    }
    
    void printIn(TreeNode node) {
        if(node == null) return;
        printIn(node.left);
        System.out.print(node.val + " ");
        printIn(node.right);
    }

    void printPre(TreeNode node) {
        if(node == null) return;
        System.out.print(node.val + " ");
        printPre(node.left);
        printPre(node.right);
    }

    // todo: 
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) return null;
        
        Map<Integer, TreeNode> map = new HashMap<>();
        TreeNode root = new TreeNode(preorder[0]), prevNode = root;
        int prev = find(root.val, inorder); map.put(root.val, root);

        for(int i=1; i<preorder.length; i++) { 
            TreeNode node = new TreeNode(preorder[i]); map.put(node.val, node);

            int cur = find(node.val, inorder);
            if(cur < prev) prevNode.left = node;
            else {
                int j=1;
                while(cur-j > 0 && map.get(inorder[cur-j]) == null) j++;
                map.get(inorder[cur-j]).right = node; 
            }

            prev = cur; prevNode = node;
        }

        return root;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.buildTree(new int[] { 4, 7, 5, 3, 8, 2, 1 }, new int[] { 5, 7, 3, 4, 8, 1, 2 });
        tree.printPre(root); System.out.println();
        tree.printIn(root); System.out.println();
    }
}   