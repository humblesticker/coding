#include <unordered_map>
#include <unordered_set>
#include <vector>
using namespace std;

class AlphabetOrderDiv1 {
	unordered_map<char, vector<char>> order;

	void build(vector<string>& words) {
		for(auto& w : words) 
			for(int i=1; i<w.length(); i++) if(w[i-1] != w[i]) order[w[i-1]].push_back(w[i]);
	}	
	
	bool check(char c, unordered_set<char> path) {
		if(!path.insert(c).second) return false;
		for(auto& d : order[c]) if(!check(d, path)) return false;
		return true;
	}	
	
public:
	string isOrdered(vector<string>& words) {
		build(words);
		for(auto& e : order) {
			unordered_set<char> path;
			if(!check(e.first, path)) return "Impossible";
		}
		return "Possible";
	}
};
/*
use vector<vector<bool>> 26x26
use matrix and check diagonal elements
*/