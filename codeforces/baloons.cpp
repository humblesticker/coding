#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

class baloons {
public:
	// dfs
	void dfs(int parent, int current, vector<int>& colors, vector<vector<int>>& graph) {
		int color = 1;

		for(auto child : graph[current]) {
			if(colors[child] > 0) continue;

			while(color == colors[parent] || color == colors[current]) color++;
			colors[child] = color++;

			dfs(current, child, colors, graph);
		}
	}
};

int main() {
	int n, s, t; cin >> n;
	vector<vector<int>> graph(n+1);
	for(int i=0; i<n-1; i++) { cin >> s >> t; graph[s].push_back(t); graph[t].push_back(s); }

	vector<int> colors(n+1); colors[1] = 1;
	baloons b; b.dfs(0, 1, colors, graph);

	int mcolor = 1;
	for(auto c : colors) mcolor = max(mcolor, c); cout << mcolor << endl;
	for(auto c : colors) if(c > 0) cout << c << " "; cout << endl;
	return 0;
}