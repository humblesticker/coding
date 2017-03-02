#include <vector>
#include <unordered_set>
using namespace std;

class Multi {
	bool duplicate(const vector<vector<int>>& grid, int rs, int re, int cs, int ce) {
		unordered_set<int> set;
		for(int i=rs; i<re; i++) 
			for(int j=cs; j<ce; j++) 
				if(grid[i][j] > 0 && !set.add(grid[i][j]).second) return false;
		return true;
	}

public:
	bool valid(const vector<vector<int>>& grid) {
		int n = 9, gsize = 3;
		for(int i=0; i<n; i++) 
			if(duplicate(grid, i, i+1, 0, n)) return false;

		for(int i=0; i<n; i++)
			if(duplicate(grid, 0, n, i, i+1)) return false;

		for(int i=0; i<9; i+=gsize)
			for(int j=0; j<9; j+=gsize)
				if(duplicate(grid, i, i+gsize, j+jsize)) return false;

		return true;
	}
};

int main() {
	vector<int> A = { 3, 2, 0, 0, 2, 0, 1 };
}