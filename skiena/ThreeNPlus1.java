/*
	cache result, up to 10e6 ?
	from large to small, cache all intermediate steps
*/
import java.util.*;

public class ThreeNPlus1 {
	private Map<Integer, Integer> cache = null;
	public ThreeNPlus1(Map<Integer, Integer> c) { cache = c; }

	private int count(int n) {
		List<Integer> list = new ArrayList<Integer>();
		int count = 0;
		while(n >= 1) {
			list.add(n);
			if(cache.containsKey(n)) { count += cache.get(n); break; }
			else count++;

			if(n%2 == 0) n /= 2;
			else n = 3*n + 1;
		}

		// update cache
		int max = count;
		for(int num : list) cache.put(num, max--);

		return count;
	}

	public int max(int i, int j) {
		int start = Math.min(i, j), end = Math.max(i, j), max = 0;
		for(int k=start; k<=end; k++) {
			cache.put(k, count(k));
			max = Math.max(max, cache.get(k));
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
		cache.put(1, 1);

		while(s.hasNextInt()) {
			int i = s.nextInt(), j = s.nextInt();
			System.out.println(i + " " + j + " " + (new ThreeNPlus1(cache)).max(i, j));
		}
	}
}