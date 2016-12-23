// sentinel ?
public class LinkedList<T> {
	class Node<T> {
		int key; // ?
		T data;
		Node<T> next;
		Node(int k, T d) { key = k; data = d; }
	}

	Node<T> head = null;

	// search, O(n)
	public T search(int key) {
		Node<T> cur = head;
		while(cur != null) {
			if(cur.key == key) return cur.data;
			cur = cur.next;
		}
		return null;
	} 

	// add front
	public void add(T data) {
		int key = 0; if(head != null) key = head.key + 1;
		Node<T> node = new Node<T>(key, data);
		node.next = head;
		head = node;
	}

	// delete
	public void delete(int key) {
		Node<T> cur = head, prev = null;
		while(cur != null && cur.key != key) { prev = cur; cur = cur.next; }

		if(cur == null) return;
		prev.next = cur.next;
	}

	public void print() {
		Node<T> cur = head;
		while(cur != null) { 
			System.out.print(cur.data + ",");
			cur = cur.next;	
		}
		System.out.println();
	}

	void reverse(Node<T> node) {
		if(node == null) return;
		reverse(node.next);
		System.out.print(node.data + ",");
	}

	// print reverse
	public void reverse() {
		reverse(head);
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList<String> names = new LinkedList<String>();
		names.add("brian");
		names.add("ben");
		names.add("brian jr");
		names.add("susana");
		names.print();

		names.reverse();

		System.out.println(names.search(2));

		names.delete(2);
		names.print();
	}
}