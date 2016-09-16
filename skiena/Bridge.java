import java.util.*;

public class Bridge {
	LinkedList<Integer> left;
	LinkedList<Integer> right;
	int total = 0;
	List<String> logs = new ArrayList<String>();
	Bridge(LinkedList<Integer> l, LinkedList<Integer> r) { left = l; right = r; }

	void first2toLeft() {
		String log = ""; int max = Integer.MIN_VALUE;
		for(int i=0; i<2 && right.size() > 0; i++) {
			int p = right.removeFirst(); 
			left.add(i, p);
			max = Math.max(max, p);
			log += (log.length() == 0 ? p : " " + p);
		}
		total += max;
		logs.add(log);
	}

	void last2toLeft() {
		String log = ""; int max = Integer.MIN_VALUE;
		for(int i=0; i<2 && right.size() > 0; i++) {
			int p = right.removeLast(); 
			left.addLast(p);
			max = Math.max(max, p);
			log += (log.length() == 0 ? p : " " + p);
		}
		total += max;
		logs.add(log);
	}

	void first1toRight(int pos) {
		int p = left.removeFirst(); 
		right.add(pos, p);
		total += p;
		logs.add("" + p);
	}

	void cross() {
		if(right.size() == 0) return;

		while(true) {
			first2toLeft(); if(right.size() == 0) break;
			first1toRight(0);
			last2toLeft(); if(right.size() == 0) break;
			first1toRight(1);
		}

		System.out.println(total);
		for(String log : logs) System.out.println(log);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = Integer.parseInt(s.nextLine());
		while(T > 0) {
			s.nextLine();
			int N = Integer.parseInt(s.nextLine());
			LinkedList<Integer> right = new LinkedList<Integer>();
			for(int i=0; i<N; i++) right.addLast(Integer.parseInt(s.nextLine()));
			Collections.sort(right);
			(new Bridge(new LinkedList<Integer>(), right)).cross();
			T--; if(T > 0) System.out.println();
		}
	}
}