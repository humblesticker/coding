/*
linked list is a pointer, merge into new list --> simpler
*/
public class Merge {
	public static void merge(LinkedList<Integer> list1, LinkedList<Integer> list2) {
		Node<Integer> n1 = list1.head.next, n2 = list2.head.next, cur = list1.head;
		while(n1 != null && n2 != null) {
			if(n1.data < n2.data) { cur.next = n1; n1 = n1.next; }
			else { cur.next = n2; n2 = n2.next; }
			cur = cur.next;
		}
		cur.next = (n1 != null ? n1 : n2);
	}

	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<Integer>(), list2 = new LinkedList<Integer>();
		list1.add(5);
		list1.add(3);
		list1.add(1);
		list1.print();

		list2.add(3);
		list2.add(2);
		list2.print();

		merge(list1, list2);
		list1.print();
	}
}