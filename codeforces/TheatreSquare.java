/*
ma = m/a if m%a != 0 ma++
same for n
return na * ma

10^9 use long
*/
import java.util.*;

public class TheatreSquare {
	static long count(int n, int a) {
		int f = n/a; if(n%a != 0) f++;
		return f;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(), m = s.nextInt(), a = s.nextInt();
		System.out.println(count(n, a) * count(m, a));
	}
}