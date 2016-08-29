/*
sort 

1) first 2 <-- remove first 2 from right and addFirst to left
2) frist 1 --> remove frist 1 from left and addFirst to right
3) last 2 <-- remove last 2 from right and addlast to left
4) first 1 --> remove frist 1 from left and addFirst to right

after 1) and 3) check if right is empty. If empty done
*/
import java.util.*;

public class Bridge {
	LinkedList<Integer> left;
	LinkedList<Integer> right;
	int total = 0;

	void first2toLeft() {
		String log = ""; int max = Integer.MIN_VALUE;
		for(int i=0; i<2 && right.size() > 0; i++) {
			int p = right.removeFirst(); 
			left.addFirst(p);
			max = Math.max(max, p);
			log += (log.length() == 0 ? p : " " + p);
		}
		total += max;
		System.out.println(log);
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
		System.out.println(log);
	}

	void first1toRight() {
		int p = left.removeFirst(); 
		right.addFirst(p);
		total += p;
		System.out.println(p);
	}

	void cross() {
		while(true) {
			first2toLeft(left, right); if(right.size() == 0) break;
			first1toRight(left, right);
			last2toLeft(left, right); if(right.size() == 0) break;
			first1toRight(left, right);
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = Integer.parseInt(s.nextLine());
		while(T > 0) {
			s.nextLine();
			int N = 
			T--;
		}
	}
}