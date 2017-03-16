#include <vector>
using namespace std;

class ForwardMancala {
public:
	vector<int> findMoves(vector<int>& slots) {
		int sum = 0, i = 0, n = slots.size(); vector<int> X;
		for(auto s : slots) sum += s;
		
		while(true) {
			if(slots[0] == sum) break;
			i = (i+1)%n; if(i == 0 || slots[i] == 0) continue;

			int count = slots[i], j = i; 
			slots[i] = 0; X.push_back(i);
			while(count--) { j = (j+1)%n; slots[j]++; }
		}
		return X;
	}
};