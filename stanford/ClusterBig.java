/*
N: 2x10^5
how to handle duplicate values
*/
import java.util.*;

public class ClusterBig {
	static List<Integer> within2(int num, int bit) {
		List<Integer> list = new LinkedList<Integer>();
		list.add(num);
		for(int i=0; i<bit; i++) list.add(num ^ 1 << i);

		for(int i=0; i<bit; i++) 
			for(int j=i+1; j<bit; j++) list.add((num ^ 1 << i) ^ 1 << j);
		//System.out.println(list);
		return list;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt(), bit = s.nextInt(), k = N; s.nextLine();
		UF uf = new UF(N);

		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		int[] keys = new int[N+1];
		for(int i=1; i<=N; i++) {
			int key = Integer.parseInt(s.nextLine().replaceAll(" ", ""), 2);
			keys[i] = key;

			if(!map.containsKey(key)) map.put(key, new LinkedList<Integer>());
			map.get(key).add(i);
		}

		for(int i=1; i<keys.length; i++) {
			List<Integer> list = within2(keys[i], bit);
			for(int key : list) 
				if(map.containsKey(key)) {
					for(int nid : map.get(key)) if(uf.union(i, nid)) k--;
				}
		}
		
		System.out.println(k);
	}
}