/*
assume list is sorted
case
	empty l1, l2
	l1 larger, l2 larger, l1 and l2 same size
*/
public class Merge {
	public static void merge(LinkedList<Integer> list1, LinkedList<Integer> list2) {
		Node<Integer> n1 = list1.head.next, n2 = list2.head.next, prev = list1.head;
		while(n1 != null && n2 != null) {
			if(n1.data < n2.data) { prev = n1; n1 = n1.next; }
			else { 
				Node<Integer> insert = n2; n2 = n2.next; // save n2
				prev.next = insert; insert.next = n1; // insert before n1
				prev = insert;
			}
		}

		if(n2 != null) prev.next = n2; // connect rest of n2 to the end of n1
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

		merge(list2, list1);
		list2.print();
	}
}