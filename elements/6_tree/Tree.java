public class Tree<T> {
	class TreeNode<T> {
		TreeNode<T> left;
		TreeNode<T> right;
		T data;
	}

	TreeNode<T> root;

	// root first
	void preOrder(TreeNode<T> node) {
		if(node == null) return;
		System.out.println(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}

	// root between
	void inOrder(TreeNode<T> node) { }

	// root last
	void postOrder(TreeNode<T> node) { }

	public void preOrder() { preOrder(root); }

	/*
	for all nodes left and right child's height diff <= 1
	post order root 
		compare left, right's height
	*/
	public boolean balanced() {
		return count(root) >= 0;
	}

	// return -1 if not balanced
	int count(TreeNode<T> node) {
		if(node == null) return 0;

		int l = count(node.left), r = count(node.right);
		if(Math.abs(l-r) > 1) return -1;
		else return Math.max(l, r) + 1;
	}
}