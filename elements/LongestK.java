import java.util.*;

public class LongestK {
	public List<String> get(int k, Iterator<String> input) {
		PriorityQueue<String> minq = new PriorityQueue<String>((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		while(input.hasNext()) {
			String cur = input.next();
			if(minq.size() < k) minq.add(cur);
			else if(cur.length() > minq.peek().length()) { minq.poll(); minq.add(cur); }
		}

		List<String> list = new ArrayList<String>();
		while(minq.size() > 0) list.add(minq.poll());
		return list;
	}

	public static void main(String[] args) {
		(new LongestK()).get(Integer.parseInt(args[0]), new Scanner(System.in)).forEach(System.out::println);
	}
}