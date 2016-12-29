import java.util.*;

public class Merge {
	class Item {
		int id; int value; Item(int i, int v) { id = i; value = v; }
	}

	public List<Integer> merge(List<List<Integer>> sortedArrays) {
		List<Iterator<Integer>> iters = new ArrayList<>();
		for(List<Integer> list : sortedArrays) iters.add(list.iterator());	

		List<Integer> sorted = new LinkedList<>();
		PriorityQueue<Item> pq = new PriorityQueue<>((i1, i2) -> i1.value - i2.value); 

		int i = 0;
		for(Iterator<Integer> iter : iters) 
			if(iter.hasNext()) pq.offer(new Item(i++, iter.next())); 

		while(pq.size() > 0) {
			Item min = pq.poll(); sorted.add(min.value);
			Iterator<Integer> iter = iters.get(min.id); 
			if(iter.hasNext()) pq.offer(new Item(min.id, iter.next()));
		}

		return sorted; 
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		List<List<Integer>> arrays = new LinkedList<>();

		while(k-- > 0) {
			int n = s.nextInt(); 
			List<Integer> list = new LinkedList<>();
			while(n-- > 0) list.add(s.nextInt());
			arrays.add(list);
		}

		System.out.println((new Merge()).merge(arrays));
	}	
}