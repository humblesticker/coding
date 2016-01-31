/*
	cache result, up to 10e6 ?
	from large to small, cache all intermediate steps
*/
import java.util.*;

public class ThreeNPlus1 {
	private Map<Integer, Integer> cache = new HashMap<Integer, Integer>();

	private int count(int n) {
		List<Integer> list = new ArrayList<Integer>();
		int count = 1;
		while(n != 1) {
			list.add(n);
			if(cache.containsKey(n)) { count += cache.get(n); break; }
			if(n%2 == 0) n /= 2;
			else n = 3*n + 1;
			count++;
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
		while(s.hasNextLine()) {
			int i = s.nextInt(), j = s.nextInt();
			System.out.println(i + " " + j + " " + (new ThreeNPlus1()).max(i, j));
		}
	}
}