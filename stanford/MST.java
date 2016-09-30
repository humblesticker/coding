/*
union find mst, 4(k) cluster what is max spacing
minq of edges

k = N
while k > 4
	everytime merge k--
106
 */
import java.util.*;

public class MST {
	static class Edge {
		int s; int t; int w; 
		Edge(int s, int t, int w) { this.s = s; this.t = t; this.w = w; }
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt(); 
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(N, (e1, e2) -> e1.w - e2.w);
		while(s.hasNext()) pq.add(new Edge(s.nextInt(), s.nextInt(), s.nextInt()));


		int k = N; UF uf = new UF(N);
		while(k > Integer.parseInt(args[0])) {
			Edge e = pq.poll(); 
			if(uf.union(e.s, e.t)) k--;
		}

		Edge e = pq.poll(); 
		while(!uf.union(e.s, e.t)) e = pq.poll(); 	
		System.out.println(e.w);
	}
}