#include <vector>
#include <string>
#include <iostream>
using namespace std;

class StringGame {
public:
	bool check(string& t, const string& p) {
		int i = 0, j = 0;
		while(i < p.length()) {
			int k = t.find(p[i], j); if(k == string::npos) return false;
			i++; j = k+1;
		}
		return true;
	}	
};

int main() {
	const char removed = ' ';
	StringGame game;
	string t, p; cin >> t >> p;
	vector<int> order(t.length() - p.length()); for(int i=0; i<order.size(); i++) cin >> order[i];

	int l = 0, h = order.size() - 1, mid; // max

	while(l <= h) {
		string copy = t;
		mid = (l + h)/2;
		for(int i=0; i<=mid; i++) copy[order[i]-1] = removed;

		if(game.check(copy, p)) l = mid+1;
		else h = mid-1;
	}
	
	cout << l << endl;
}