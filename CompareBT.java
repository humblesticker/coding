/*
class TreeNode {
	int val; TreeNode left; TreeNode right;
	boolean done; 
}
*/
import java.util.*;

public class CompareBT {
	// get next node with no left child not visited
	// push all node not done encountered to stack
	// return null if all node
	TreeNode next(TreeNode node, Stack<TreeNode> stack) {
		
	}

	// 
	boolean equal(TreeNode t1, TreeNode t2) {
		Stack<TreeNode> stack1 = new Stack<>(), stack2 = new Stack<>();
		stack1.push(t1); stack2.push(t2);

		while(!stack1.empty() || !stack2.empty()) {
			if(stack1.empty() || stack2.empty()) return false; // size not match

			// pop from stack 
			// get next. mark as done compare if not same return false
		}
		return true;
	}
}