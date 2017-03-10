#include <vector>
#include <algorithm>
#include <iostream>
#include <queue>
using namespace std;

/*
recursive with 2 variables passing
*/
class baloons {
	int find(int node, int start, pair<int, int> used, int n) {
		for(int i=start; i<=n; i++) 
			if(i != used.first && i != used.second) return i; 
		return -1;
	}

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
	int n, i, j; cin >> n;
	vector<vector<int>> graph(n);
	int count = 1; // total n-1
	while(count++ < n) {
		cin >> i >> j;
		graph[i-1].push_back(j-1); graph[j-1].push_back(i-1);
	}

	vector<int> colors(n);
	baloons b; b.color(colors, graph);

	int mcolor = 1;
	for(auto c : colors) mcolor = max(mcolor, c);
	cout << mcolor << endl;

	for(auto c : colors) cout << c << " ";
	cout << endl;

	return 0;
}