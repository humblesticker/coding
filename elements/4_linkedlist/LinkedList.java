/*
singley linked list with sentinel head
*/
public class LinkedList<T> {
	Node<T> head = new Node<T>(null);

	/*
	search, O(n)
	*/
	public Node<T> search(T data) {
		Node<T> node = head;
		while(node != null) {
			if(data.equals(node.data)) return node;
			node = node.next;
		}
		return null;
	} 

	/*

	*/
	public void add(T data) {
		Node<T> node = new Node<T>(data);
		node.next = head.next; head.next = node;
	}

	public void delete(T data) {
		Node<T> node = head;
		while(node.next != null) {
			if(data.equals(node.next.data)) { node.next = node.next.next; return; }
			node = node.next;
		}
	}

	public void print() {
		Node<T> node = head;
		while(node != null) { 
			if(node.data != null) System.out.print(node.data + ",");
			node = node.next;
		}
		System.out.println();
	}

	/*
	recursively get to the last node and add from there
	tail recrusion using 2 ref [ ]
	TODO [ ] why this is not working?
	*/
	void reverse(Node<T> node) {
		if(node.next == null) { head.next = node; return; }
		reverse(node.next);

		if(node.data == null) node.next.next = null; 
		else node.next.next = node;
	}

	public void reverse2() {
		reverse(head);
	}
	
	/*
	iterative

	*/
	public void reverse() {
		Node<T> prev = null, cur = head.next, next = null;
		while(cur != null) {
			next = cur.next; // save
			cur.next = prev; // reverse
			prev = cur; cur = next; // iterate
		}
		head.next = prev;
	}

	public static void main(String[] args) {
		LinkedList<String> names = new LinkedList<String>();
		names.add("brian");
		names.add("ben");
		names.add("brian jr");
		names.add("susana");
		names.print();

		//System.out.println(names.search("brian").data);
		names.reverse2();
		names.print();
		
	// 	names.delete("brian"); // first
	// 	names.print();

	// 	names.delete("susana"); // last
	// 	names.print();
	}
}