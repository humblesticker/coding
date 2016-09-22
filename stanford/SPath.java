/*
directed and weighted

1st: simple O(mn)
node number from 0 to n-1
adjacency list: array of Linked List of edge (node, weight)
distance array: 0th element 0 and all others as MAX (infinite)
from array: all -1
completed array: false

while true
	get minNode not completed, if not found break
	process all edges, update distance
	mark minNode completed

min(distance, completed)
	get node not completed with min distance
	if not found retur -1
 */
public class SPath {
	class Edge { int node; int weight; Edge(int n, int w) { node = n; weight = w; } }
	LinkedList<Edge>[] adjs;
	SPath(LinkedList<Edge>[] list) { adjs = list; }

	public void process() {

	}

	public static void main(String[] args) {
		(new SPath()).process();
	}
}