/*
(d, d) initiallized as (1, 1) 
if hit horizontal bound (-d, d), vertical (d, -d)
corner stop

sensor's time is initialized as -1
every sec 
	update pos 
	if (one of the sensor met and not -1) set time


10^5 n, m, k
1d time array of 10^10 (long) 
1d order array for print out
*/
import java.util.*;

public class RayTracing {
	static long key(int x, int y, int m) {
		return (long)x*(m+1) + y;
	}

	static boolean isCorner(int x, int y, int n, int m) {
		return (x == 0 && y == 0) || (x == 0 && y == m) || 
			(x == n && y == 0) || (x == n && y == m);
	}

	static void trace(Map<Long, Long> time, int n, int m) {
		int x = 0, y = 0, dx = 1, dy = 1;
		long now = 0;
		do {
			x += dx; y += dy; now++;
			long key = key(x, y, m); if(time.containsKey(key) && time.get(key) < 0) time.put(key, now);

			if(x == 0 || x == n) dx = -dx;
			if(y == 0 || y == m) dy = -dy;
		} while(!(isCorner(x, y, n, m)));
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(), m = s.nextInt(), k = s.nextInt();
		long[] order = new long[k]; Map<Long, Long> time = new HashMap<Long, Long>();
		for(int i=0; i<k; i++) { 
			long key = key(s.nextInt(), s.nextInt(), m); 
			order[i] = key; time.put(key, -1L);
		}
		trace(time, n, m);

		// print in order
		for(int i=0; i<order.length; i++) System.out.println(time.get(order[i]));
	}
}