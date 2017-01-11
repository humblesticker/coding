import java .util.*;

public class IntegerList {
	public List<Integer> intersect(List<Integer> l1, List<Integer> l2) {
		int i1 = 0, i2 = 0; List<Integer> list = new LinkedList<>();
		while(i1 < l1.size() && i2 < l2.size()) {
			int item1 = l1.get(i1), item2 = l2.get(i2);
			if(item1 < item2) i1++;
			else if(item2 < item1) i2++;
			else {
				if(i1 == 0 || item1 != l1.get(i1-1)) list.add(item1);
				i1++; i2++;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
		l1.add(1); l1.add(3); l1.add(3); l1.add(6);
		l2.add(2); l2.add(3); l2.add(3); l2.add(5); l2.add(6); l2.add(7);
		System.out.println(new IntegerList().intersect(l1, l2));
	}
}