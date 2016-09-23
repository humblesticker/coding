import java.util.*;

public class MSTPrim {
	static class Edge { 
		int dest; int w; 
		Edge(int d, int w) { dest = d; this.w = w; } 
	}

	List<Edge>[] nodes; int cost; boolean[] visited;
	MSTPrim(List<Edge>[] nodes) { this.nodes = nodes; visited = new boolean[nodes.length]; }

	void find() {
		PriorityQueue<Edge> q = new PriorityQueue<Edge>(10, (e1, e2) -> e1.w - e2.w); 
		cost = 0; int cur = 1, count = 1; Edge min;

		do {
			for(Edge edge : nodes[cur]) if(!visited[edge.dest]) q.add(edge);
			visited[cur] = true;

			do { min = q.poll(); } while(visited[min.dest]); 
			cost += min.w; count++; cur = min.dest;
		} while(count < nodes.length-1);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt(), E = s.nextInt();
		List<Edge>[] nodes = (List<Edge>[])new LinkedList[N+1];
		for(int i=1; i<nodes.length; i++) nodes[i] = new LinkedList<Edge>();

		while(E-- > 0) {
			int src = s.nextInt(), dest = s.nextInt(), w = s.nextInt();
			nodes[src].add(new Edge(dest, w));
			nodes[dest].add(new Edge(src, w));
		}
		
		MSTPrim mst = new MSTPrim(nodes);
		mst.find();
		System.out.println(mst.cost);
	}
}
// -3612829