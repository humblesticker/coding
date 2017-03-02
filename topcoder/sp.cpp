/*
Given an undirected graph G having N (1<N<=1000) vertices and positive weights. 
Find the shortest path from vertex 1 to vertex N, or state that such path doesn’t exist.
*/
class sp {
	
}
/*
S[n] init as max, visited[n] init as false
set S[0] to 0
vector<vector<edge>> graph
edge(t, w)

until all nodes are processed
	get node i not visited yet with min value 
	for edges for node
		update S[t] if S[i] + Ew < S[t] 
	mark node as visited
	
if(S[n-1] == max) return -1 
else return S[n-1]
*/