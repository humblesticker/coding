/*
graph as adjacency list 
	List<Integer>[] nodes

minq of edges by dist
arrays 
	dist, src node with 0 dist, all others as max value
	from, -1
	visited, false


insert all edges of src to minq (dist)

while minq is not empty
	pop an edge (with min dist) 
	flex the edge (update dest node's distance, from if needed)


prove ?


 */
public class SPath {
	public void search() {

	}
}