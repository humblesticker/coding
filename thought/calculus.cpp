/*
input?

2x^2 + x + 6 > 4x + 1
(0, 6), (1, 1), (2, 2) -> (0, 1), (1, 4)

assume only one variable
map<int, int> (exp, co)

map out
loop map
	if(exp == 0) continue
	map[exp - 1] = exp*co


struct term?

*/
#include <map>
#include <vector>
using namespace std;

struct term {
	int exp; int co;
	term(int e, int c) { exp = e; co = c; }
	term derivative() { return term(exp-1, exp*co); }
	void derive() {
		int t = exp; exp--;
		co *= t;
	}
}

class calculus {
public:
	map<int, int> derivative(map<int, int>& poly) {
		map<int, int> out;
		for(auto& item : poly) {
			if(item.first == 0) continue;
			item[item.first-1] = item.first * item.second;
		}
		return out;
	}

	// immutable is usually better unless there is sizable performance drawback
	vector<term> derivative(vector<term> terms) {
		vector<term> out; 
		for(auto& term : terms) {
			if(term.exp == 0) continue;
			out.add(term.derivative());
		}
		return out;
	}

	// mutable: make sure no one reference erased one
	void derivative_inplace(vector<term> terms) {
		for (auto i = terms.begin(); i != terms.end();) {
			if(i->exp == 0) i = terms.erase(i); 
  			else ++i;
  		}
  	}
};