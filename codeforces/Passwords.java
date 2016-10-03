import java.util.*;

public class Passwords {
	static String match(int[] count, int len, int k) {
		int lesser = 0, equal = 0;
		for(int n : count) { if(n < len) lesser++; if(n == len) equal++; }
		int best = lesser + 1, worst = lesser + equal;
		return String.format("%d %d", (best-1)/k*5 + best, (worst-1)/k*5 + worst);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] count = new int[s.nextInt()]; int k = s.nextInt();
		for(int i=0; i<count.length; i++) count[i] = s.next().length();
		System.out.println(match(count, s.next().length(), k));
	}
}