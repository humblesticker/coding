/*
what is subtree? single node? or count > 1
*/
import java.util.*;

public class Tree {
    class TreeNode {
        int val; TreeNode left; TreeNode right;
        TreeNode(int v) { val = v; }
        boolean isLeaf() { return left == null && right == null; }
    } 

    // match only tree not a single node
    boolean match(TreeNode src, TreeNode target) {
        if(src == null && target == null) return true;
        if(src == null || target == null || src.val != target.val) return false;

        return match(src.right, target.right) && match(src.left, target.left);  
    }

    // ~ n^2 
    boolean match(List<TreeNode> trees) {
        for(TreeNode i : trees)
            for(TreeNode j : trees) 
                if(i != j && !i.isLeaf() && !   j.isLeaf() && match(i, j)) { 
                    System.out.println(i.val + "," + j.val); 
                    return true; 
                }
        return false;
    }

    public boolean haveSame(TreeNode node) {
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        navigate(node, map);

        for(Map.Entry<Integer, List<TreeNode>> e : map.entrySet()) {
            List<TreeNode> list = e.getValue();
            if(list.size() > 1 && match(list)) return true;
        }
        return false;
    }

    // you can use simple hashing instead of root (bottom up)
    void navigate(TreeNode node, Map<Integer, List<TreeNode>> map) {
        if(node == null) return;

        int key = node.val;
        if(!map.containsKey(key)) map.put(key, new LinkedList<TreeNode>());
        map.get(key).add(node);

        navigate(node.left, map);
        navigate(node.right, map);
    }

    TreeNode create(int val, int left, int right) {
        TreeNode node = new TreeNode(val);
        node.left = new TreeNode(left); node.right = new TreeNode(right);
        return node;
    }

    // todo: create binary tree based on inorder and preorder
    TreeNode build() {
        TreeNode node1 = new TreeNode(2);
        node1.left = create(4, 7, 8); node1.right = new TreeNode(5);

        TreeNode node2 = new TreeNode(3);
        node2.left = create(3, 2, 6); node2.right = create(4, 7, 8);    

        TreeNode node = new TreeNode(1);
        node.left = node1; node.right = node2;
        return node;
    }
    
    public static void main(String[] args) {
        Tree tree = new Tree();
        System.out.println(tree.haveSame(tree.build()));
    }
}
//Write a procedure that given a binary tree, it will determine if said tree contains any equivalent subtrees.
// e.g. for the following tree, the procedure will return true for 4->7,8
/**
 *             1
 *       2            3
 *     4   5        3   4
 *  7  8         2  6   7  8
**/