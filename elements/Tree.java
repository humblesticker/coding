public class Tree<T> {
	class TreeNode<T> {
		TreeNode<T> left;
		TreeNode<T> right;
		T data;
	}

	TreeNode<T> root;

	void preOrder(TreeNode<T> node) {
		if(node == null) return;
		System.out.println(node.date);
		preOrder(node.left);
		preOrder(node.right);
	}

	void inOrder(TreeNode<T> node) {
		if(node == null) return;
		preOrder(node.left);
		System.out.println(node.date);
		preOrder(node.right);
	}

	void postOrder(TreeNode<T> node) {
		if(node == null) return;
		preOrder(node.left);
		preOrder(node.right);
		System.out.println(node.date);
	}

	public void preOrder() { preOrder(root); }
}