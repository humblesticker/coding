/*
Sn = max { S1 + w1, S2 + w2, S3 + w3 } where 1, 2, 3 are nodes connecting to n
~ O(N + E)

detect negative cycle
	
 */
}
import java.util.*;

public class BellmanFord {
	class Edge { int node; int weight; Edge(int n, int w) { node = n; weight = w; } }
	LinkedList<Edge>[] adjs;

	public void process() {

	}

	public static void main(String[] args) {
		(new BellmanFord()).process();	
	}
}