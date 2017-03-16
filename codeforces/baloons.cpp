#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

// todo: simpler recursive ~ up to 2 x 10^5 is ok for recursive
class baloons {
public:
	void color(vector<int>& colors, vector<vector<int>>& graph) {
		int n = graph.size();
		vector<int> parent(n); vector<bool> visited(n);
		queue<int> q; colors[0] = 1; q.push(0); 

		while(!q.empty()) {
			int node = q.front();
			auto children = graph[node];

			int num = 0;
			for(auto child : children) {
				if(visited[child]) continue;
				parent[child] = node;
				num = find(child, num+1, make_pair(colors[node], colors[parent[node]]), n); 
				if(num < 0) break; 

				colors[child] = num;
				q.push(child);
			}
			q.pop();
			visited[node] = true;
		}
	}
};

int main() {
	int n, i, j; cin >> n; n++;
	vector<vector<int>> graph(n);
	for(int i=0; i<n-1; i++) {
		cin >> i >> j; graph[i].push_back(j); graph[j].push_back(i);
	}

	vector<int> colors(n);
	baloons b(graph); b.color(colors, graph);

	int mcolor = 1;
	for(auto c : colors) mcolor = max(mcolor, c); cout << mcolor << endl;
	for(auto c : colors) cout << c << " "; cout << endl;
	return 0;
}