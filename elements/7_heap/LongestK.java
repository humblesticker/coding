import java.util.*;

public class LongestK {
	public List<String> get(int k, Iterator<String> input) {
		PriorityQueue<String> minq = new PriorityQueue<String>((s1, s2) -> Integer.compare(s1.length(), s2.length())); 
		while(input.hasNext()) {
			minq.add(input.next()); if(minq.size() > k) minq.poll();
		}

		return new ArrayList<String>(minq);
	}

	public static void main(String[] args) {
		(new LongestK()).get(Integer.parseInt(args[0]), new Scanner(System.in)).forEach(System.out::println);
	}
}