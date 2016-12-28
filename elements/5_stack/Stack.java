public class Stack {
	/*
	push into stack
	pop and print
	*/
	public void printReverse(Node<Integer> head) {
		LinkedList<Integer> stack = new LinkedList<Integer>();
		Node<Integer> node = head.next;
		while(node != null) { stack.add(node.data); node = node.next; }
		
		node = stack.head.next;
		while(node != null) System.out.println(node.data + ",");
		System.out.println();
	}

	/*
	O(1) time, O(n) space
	*/
	public void max() {

	}
}